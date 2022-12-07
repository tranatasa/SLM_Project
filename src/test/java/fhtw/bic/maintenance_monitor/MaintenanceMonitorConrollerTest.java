package fhtw.bic.maintenance_monitor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MaintenanceMonitorConrollerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldSetCorrectMessage(){
        String expectedResult = "TestString";
        testRestTemplate.getForObject("http://localhost:" + port + "/api/setMessage?message="+expectedResult,String.class);
        String test = testRestTemplate.getForObject("http://localhost:" + port + "/api/getMessage",String.class);
        assertEquals(expectedResult, test);

    }

@Test
    public void shouldResetMessage(){
        String standardmsg = "Everything operates as expected";
        testRestTemplate.getForObject("http://localhost:" + port + "/api/setMessage?message=asdfasdf",String.class);
        testRestTemplate.getForObject("http://localhost:" + port + "/api/resetMessage",String.class);
        String actualresult = testRestTemplate.getForObject("http://localhost:" + port + "/api/getMessage",String.class);
        assertEquals(standardmsg, actualresult);
    }

    @Test public void shouldGetStandardMessage(){
        String standardmsg = "Everything operates as expected";
        String actualresult = testRestTemplate.getForObject("http://localhost:" + port + "/api/getMessage",String.class);
        assertEquals(standardmsg, actualresult);
    }


}