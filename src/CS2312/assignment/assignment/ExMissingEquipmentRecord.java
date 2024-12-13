package CS2312.assignment.assignment;

/** Exception thrown when attempting to access an equipment record that does not exist */
public class ExMissingEquipmentRecord extends Exception {

    /** Create exception with custom message */
    public ExMissingEquipmentRecord(String message) {
        super(message);
    }
}
