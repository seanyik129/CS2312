package CS2312.assignment.assignment;

/** Exception thrown when attempting to set a new system date that is invalid or earlier than current date */
public class ExInvalidNewDay extends Exception {

    /** Create exception with custom message */
    public ExInvalidNewDay(String message) {
        super(message);
    }
}
