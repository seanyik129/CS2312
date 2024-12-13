package CS2312.assignment.assignment;

/** Exception thrown when the number of days specified is invalid or out of range */
public class ExInvalidDays extends Exception {

    /** Create exception with custom message */
    public ExInvalidDays(String message) {
        super(message);
    }
}
