package CS2312.assignment.assignment;

/** Exception thrown when attempting to borrow equipment that is not available */
public class ExUnavailableEquipment extends RuntimeException {

    /** Create exception with custom message */
    public ExUnavailableEquipment(String message) {
        super(message);
    }
}
