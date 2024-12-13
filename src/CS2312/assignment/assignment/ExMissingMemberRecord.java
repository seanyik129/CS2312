package CS2312.assignment.assignment;

/** Exception thrown when attempting to access a member record that does not exist */
public class ExMissingMemberRecord extends RuntimeException {

    /** Create exception with custom message */
    public ExMissingMemberRecord(String message) {
        super(message);
    }
}
