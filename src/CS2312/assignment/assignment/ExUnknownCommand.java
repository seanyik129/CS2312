package CS2312.assignment.assignment;

/** Exception thrown when an unrecognized or invalid command is entered */
public class ExUnknownCommand extends Exception {

    /** Create exception with custom message */
    public ExUnknownCommand(String message) {
        super(message);
    }
}
