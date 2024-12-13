package CS2312.assignment.assignment;

/** Exception thrown when a requested borrow/request period overlaps with existing periods */
public class ExPeriodOverlap extends Exception {

    /** Create exception with custom message */
    public ExPeriodOverlap(String message) {
        super(message);
    }
}
