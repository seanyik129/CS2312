package CS2312.lab.week10.Q1;

public class ExEmployeeNotFound extends Exception {
    public ExEmployeeNotFound() { super("Employee not found."); }
    public ExEmployeeNotFound(String message) { super(message); }
}