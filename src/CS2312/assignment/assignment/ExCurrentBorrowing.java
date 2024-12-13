package CS2312.assignment.assignment;

/** Exception for attempts to modify equipment that is currently borrowed */
public class ExCurrentBorrowing extends RuntimeException {

    /** Create exception with custom message */
    public ExCurrentBorrowing(String message) {
        super(message);
    }
}
