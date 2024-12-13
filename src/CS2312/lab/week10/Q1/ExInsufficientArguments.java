package CS2312.lab.week10.Q1;

public class ExInsufficientArguments extends Exception {
    public ExInsufficientArguments() { super("Insufficient command arguments."); }
    public ExInsufficientArguments(String message) { super(message); }
}
