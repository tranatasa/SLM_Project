package fhtw.bic.maintenance_monitor;

public class MaintenanceMonitor {

    private String Message = "Everything works as expected";

    public String getMessage() {
        return Message;
    }

    public void setMessage(String currentMessage) {
        Message = currentMessage;
    }

    public void resetMessage(){
        Message = "Everything works as expected";
    }

    public MaintenanceMonitor(){}
}
