package CS2312.lab.week10.Q1;

public class ExWrongCommand extends Exception {
    public ExWrongCommand() { super("Wrong Command."); }
    public ExWrongCommand(String message) { super(message); }
}
