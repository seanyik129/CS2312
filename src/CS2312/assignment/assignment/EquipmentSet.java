package CS2312.assignment.assignment;

import java.util.ArrayList;

public class EquipmentSet {
    private String setCode;                     // Unique identifier for this set
    private boolean isAvailableForBorrow;       // Current availability status
    private String currentBorrower;             // ID of current borrower (null if available)
    private Day borrowStartDate;                // Start date of current borrow
    private Day borrowEndDate;                  // End date of current borrow
    private ArrayList<Day> requestStartDates;    // List of request start dates
    private ArrayList<Day> requestEndDates;      // List of request end dates
    private ArrayList<String> requestMembers;    // List of members who made requests

    /** Create new equipment set with given code */
    public EquipmentSet(String setCode) {
        this.setCode = setCode;
        this.isAvailableForBorrow = true;
        this.currentBorrower = null;
        this.borrowStartDate = null;
        this.borrowEndDate = null;
        this.requestStartDates = new ArrayList<>();
        this.requestEndDates = new ArrayList<>();
        this.requestMembers = new ArrayList<>();
    }

    /** Mark set as borrowed by member for duration starting from system date */
    public void markAsBorrowed(String memberId, int duration) {
        this.currentBorrower = memberId;
        this.isAvailableForBorrow = false;
        this.borrowStartDate = SystemDate.getInstance().clone();
        this.borrowEndDate = borrowStartDate.endDay(duration);
    }

    /** Add new request for set with given parameters */
    public void addRequested(String memberId, int duration, Day startDay) {
        Day endDay = startDay.endDay(duration);
        int insertIndex = 0;

        for (int i = 0; i < requestStartDates.size(); i++) {
            if (startDay.isBefore(requestStartDates.get(i))) {
                break;
            }
            insertIndex = i + 1;
        }

        requestStartDates.add(insertIndex, startDay);
        requestEndDates.add(insertIndex, endDay);
        requestMembers.add(insertIndex, memberId);
    }

    /** Mark set as available by clearing borrow info */
    public void markAsAvailable() {
        this.isAvailableForBorrow = true;
        this.currentBorrower = null;
        this.borrowEndDate = null;
        this.borrowStartDate = null;
    }

    /** Check if set is currently available */
    public boolean isAvailableForBorrow() {
        return isAvailableForBorrow;
    }

    /** Check if set is available during given period */
    public boolean isAvailableForBorrow(Day start, Day end) {
        if (!isAvailableForBorrow && !(end.isBefore(borrowStartDate) || start.isAfter(borrowEndDate))) {
            return false;
        }

        for (int i = 0; i < requestStartDates.size(); i++) {
            Day reqStart = requestStartDates.get(i);
            Day reqEnd = requestEndDates.get(i);

            if (!(end.isBefore(reqStart) || start.isAfter(reqEnd))) {
                return false;
            }
        }
        return true;
    }

    /** Get current borrower ID */
    public String getCurrentBorrower() {
        return currentBorrower;
    }

    /** Get set code */
    public String getSetCode() {
        return setCode;
    }

    /** Get borrow end date as string */
    public String getBorrowEndDate() {
        return borrowEndDate.toString();
    }

    /** Get borrow start date as string */
    public String getBorrowStartDate() {
        return borrowStartDate.toString();
    }

    /** Get list of request start dates */
    public ArrayList<Day> getRequestStartDate() {
        return requestStartDates;
    }

    /** Get list of request end dates */
    public ArrayList<Day> getRequestEndDate() {
        return requestEndDates;
    }

    /** Get list of requesting members */
    public ArrayList<String> getRequestMembers() {
        return requestMembers;
    }

    /** Check if new request conflicts with existing requests/borrows */
    public boolean isRequestConflict(Day newStart, Day newEnd) {
        if (!isAvailableForBorrow()) {
            if (!(newEnd.isBefore(borrowStartDate) || newStart.isAfter(borrowEndDate))) {
                return true;
            }
        }

        for (int i = 0; i < requestStartDates.size(); i++) {
            Day existingStart = requestStartDates.get(i);
            Day existingEnd = requestEndDates.get(i);
            if (!(newEnd.isBefore(existingStart) || newStart.isAfter(existingEnd))) {
                return true;
            }
        }
        return false;
    }

    /** Check if member has overlapping request in given period */
    public boolean hasOverlappingRequest(String memberId, Day startDate, int duration) {
        Day endDate = startDate.clone().endDay(duration);
        for (int i = 0; i < requestMembers.size(); i++) {
            if (requestMembers.get(i).equals(memberId) &&
                    !(endDate.isBefore(requestStartDates.get(i)) || startDate.isAfter(requestEndDates.get(i)))) {
                return true;
            }
        }
        return false;
    }

    /** Check if member has overlapping request or borrow in given period */
    public boolean hasOverlappingRequestOrBorrow(String memberId, Day startDate, Day endDate) {
        if (!isAvailableForBorrow && currentBorrower.equals(memberId) &&
                !(endDate.isBefore(borrowStartDate) || startDate.isAfter(borrowEndDate))) {
            return true;
        }

        for (int i = 0; i < requestMembers.size(); i++) {
            if (requestMembers.get(i).equals(memberId) &&
                    !(endDate.isBefore(requestStartDates.get(i)) || startDate.isAfter(requestEndDates.get(i)))) {
                return true;
            }
        }
        return false;
    }
}