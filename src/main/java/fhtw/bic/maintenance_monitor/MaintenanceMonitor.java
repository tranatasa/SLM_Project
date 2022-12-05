package fhtw.bic.maintenance_monitor;

public class MaintenanceMonitor {

    private String Message = "Everything operates as expected";

    public String getMessage() {
        return Message;
    }

    public void setMessage(String currentMessage) {
        Message = currentMessage;
    }

    public void resetMessage(){
        Message = "Everything operates as expected";
    }

    public MaintenanceMonitor(){};

    public long add(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }
}
