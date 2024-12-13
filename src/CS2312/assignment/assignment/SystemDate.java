package CS2312.assignment.assignment;

/** Singleton class to maintain system-wide date */
public class SystemDate extends Day {

    // Single instance for the system date
    private static SystemDate instance;

    /** Private constructor - can only be called by createTheInstance() */
    private SystemDate(String sDay) {
        super(sDay);
    }

    /** Get the singleton instance of SystemDate */
    public static SystemDate getInstance() {
        return instance;
    }

    /** Create the singleton instance if not exists */
    public static void createTheInstance(String sDay) {
        if (instance == null)
            instance = new SystemDate(sDay);
        else
            System.out.println("Cannot create one more system date instance.");
    }
}
