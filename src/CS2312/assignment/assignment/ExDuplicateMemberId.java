package CS2312.assignment.assignment;

/** Exception thrown when attempting to register a member with an existing ID */
public class ExDuplicateMemberId extends RuntimeException {

    /** Create exception with custom message */
    public ExDuplicateMemberId(String message) {
        super(message);
    }
}