package fhtw.bic.maintenance_monitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceMonitorController {

    private MaintenanceMonitor maintenanceMonitor = new MaintenanceMonitor();
    @GetMapping("/api/message/set")
    public String setMessage(@RequestParam(name="m")String message){
        maintenanceMonitor.setMessage(message);
        return("ok");
    }

    @GetMapping("/api/message/reset")
    public String resetMessage(){
        maintenanceMonitor.resetMessage();
        return("ok");
    }

    @GetMapping("/api/message")
    public String getMessage(){
        return(maintenanceMonitor.getMessage());
    }

}
