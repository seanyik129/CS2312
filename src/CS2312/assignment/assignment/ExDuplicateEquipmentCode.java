package CS2312.assignment.assignment;

/** Exception thrown when attempting to create equipment with an existing code */
public class ExDuplicateEquipmentCode extends Exception {

    /** Create exception with custom message */
    public ExDuplicateEquipmentCode(String message) {
        super(message);
    }
}
