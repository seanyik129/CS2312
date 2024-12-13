package CS2312.assignment.assignment;

/** Exception thrown when an invalid or malformed date is provided */
public class ExInvalidDate extends Exception {

    /** Create exception with custom message */
    public ExInvalidDate(String message) {
        super(message);
    }
}
