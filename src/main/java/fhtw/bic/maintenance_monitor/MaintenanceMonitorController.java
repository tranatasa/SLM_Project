package fhtw.bic.maintenance_monitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceMonitorController {

    private MaintenanceMonitor maintenanceMonitor = new MaintenanceMonitor();
    @GetMapping("/api/setMessage")
    public String setMessage(@RequestParam(name="message")String message){
        maintenanceMonitor.setMessage(message);
        return("Set to message: "+message);
    }

    @GetMapping("/api/resetMessage")
    public String resetMessage(){
        maintenanceMonitor.resetMessage();
        return("Reset message to: 'Everything operates as expected'");
    }

    @GetMapping("/api/getMessage")
    public String getMessage(){
        return(maintenanceMonitor.getMessage());
    }

}
