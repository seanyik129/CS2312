package CS2312.assignment.assignment;

public class Day implements Cloneable {

    private int year;
    private int month;
    private int day;
    private static final String MonthNames = "JanFebMarAprMayJunJulAugSepOctNovDec";

    //Constructor
    public Day(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public Day(String sDay) {
        set(sDay);
    }

    public void set(String sDay) //Set year,month,day based on a string like 01-Mar-2024
    {
        String[] sDayParts = sDay.split("-");
        this.day = Integer.parseInt(sDayParts[0]); //Apply Integer.parseInt for sDayParts[0];
        this.year = Integer.parseInt(sDayParts[2]);
        this.month = MonthNames.indexOf(sDayParts[1]) / 3 + 1;
    }

    // check if a given year is a leap year
    static public boolean isLeapYear(int y) {
        if (y % 400 == 0)
            return true;
        else if (y % 100 == 0)
            return false;
        else if (y % 4 == 0)
            return true;
        else
            return false;
    }

    // check if y,m,d valid
    static public boolean valid(int y, int m, int d) {
        if (m < 1 || m > 12 || d < 1) return false;
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return d <= 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return d <= 30;
            case 2:
                if (isLeapYear(y))
                    return d <= 29;
                else
                    return d <= 28;
        }
        return false;
    }

    @Override
    public Day clone() {
        Day copy = null;
        try {
            copy = (Day) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }


    @Override
    public String toString() {
        return day + "-" + MonthNames.substring((month - 1) * 3, (month) * 3) + "-" + year; // (month-1)*3,(month)*3
    }

    public void nextDay() {
        day++;
        if (!valid(year, month, day)) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public Day endDay(int duration) {
        Day result = this.clone();
        for (int i = 0; i < duration; i++) {
            result.nextDay();
        }
        return result;
    }

    public boolean isAfter(Day other) {
        if (this.year > other.year) {
            return true;
        } else if (this.year == other.year) {
            if (this.month > other.month) {
                return true;
            } else if (this.month == other.month) {
                return this.day > other.day;
            }
        }
        return false;
    }

    public boolean isBefore(Day other) {
        if (this.year < other.year) {
            return true;
        } else if (this.year == other.year) {
            if (this.month < other.month) {
                return true;
            } else if (this.month == other.month) {
                return this.day < other.day;
            }
        }
        return false;
    }
}
