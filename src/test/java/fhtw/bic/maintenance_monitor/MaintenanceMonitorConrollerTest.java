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
    public void shouldDeliverCorrectResult(){


        // Generate a random String
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String expectedResult = new String(array, StandardCharsets.UTF_8);
        int actualResult= testRestTemplate.getForObject("http://localhost:" + port + "/setMessage", Integer.class);



        //Assert
        assertTrue(expectedResult.equals(actualResult));

    }

    @ParameterizedTest
    @CsvSource({"2,2,4", "-2,8,6","256,1024,1280"})
    public void SummenrechnerController_shoudReturnCorrectSum_AddIntegers(int numberOne, int numberTwo, long result){
        //Arrange
        int firstNumber= numberOne;
        int secondNUmber= numberTwo;
        long expectedResult = result;

        //Act
        int actualResult= testRestTemplate.getForObject("http://localhost:"+port+String.format("/api/summenrechner?numberOne=%s&numberTwo=%s", numberOne,numberTwo), Integer.class);

        //Assert
        assertEquals(expectedResult,actualResult);
    }



}