package CS2312.assignment.assignment;

public class CmdStartNewDay extends RecordedCommand {

    private String newDate;         // New date to set
    private SystemDate systemDate;  // System date instance
    private String oldDate;         // Current date before change
    private String[] date;          // Split components of current date

    /** Check if date string is in proper DD-MMM-YYYY format */
    public static boolean isProperFormat(String date) {
        if (date.length() != 11) return false;

        String[] parts = date.split("-");
        if (parts.length != 3) return false;

        int day;
        try {
            day = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return false;
        }

        int year;
        try {
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        int monthIndex = getMonthIndex(parts[1]);
        if (monthIndex == -1) return false;

        return Day.valid(year, monthIndex, day);
    }

    /** Check if new date is later than old date */
    private static boolean isLaterDate(String date, String oldDay) {
        int newYear = Integer.parseInt(date.substring(7, 11));
        int oldYear = Integer.parseInt(oldDay.substring(7, 11));

        if (newYear > oldYear) return true;
        if (newYear < oldYear) return false;

        int newMonth = getMonthIndex(date.substring(3, 6));
        int oldMonth = getMonthIndex(oldDay.substring(3, 6));

        if (newMonth > oldMonth) return true;
        if (newMonth < oldMonth) return false;

        int newDay = Integer.parseInt(date.substring(0, 2));
        int oldDayNum = Integer.parseInt(oldDay.substring(0, 2));

        return newDay > oldDayNum;
    }

    /** Convert month name to month number (1-12) */
    public static int getMonthIndex(String month) {
        final String[] MONTH_LIST = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < MONTH_LIST.length; i++) {
            if (MONTH_LIST[i].equals(month)) return i + 1;
        }
        return -1;
    }

    /** Execute start new day command - advance system date */
    @Override
    public void execute(String[] cmdParts) {
        try {
            newDate = cmdParts[1];
            systemDate = SystemDate.getInstance();
            date = systemDate.toString().split("-");
            if (date[0].length() < 2)
                oldDate = "0" + systemDate.toString();
            else
                oldDate = systemDate.toString();

            if (!isProperFormat(newDate))
                throw new ExInvalidDate("Invalid date.");


            if (!isLaterDate(newDate, oldDate)) {
                throw new ExInvalidNewDay("Invalid new day. The new day has to be later than the current date " + systemDate.toString() + ".");
            }

            systemDate.set(newDate);

            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        } catch (ExInvalidDate e) {
            System.out.println(e.getMessage());
        } catch (ExInvalidNewDay e) {
            System.out.println(e.getMessage());
        }
    }

    /** Undo start new day command - restore previous date */
    @Override
    public void undoMe() {
        systemDate.set(oldDate);
        addRedoCommand(this);
    }

    /** Redo start new day command - advance to new date again */
    @Override
    public void redoMe() {
        systemDate.set(newDate);
        addUndoCommand(this);
    }
}
