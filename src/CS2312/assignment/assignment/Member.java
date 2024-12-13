package CS2312.assignment.assignment;

import java.util.ArrayList;

public class Member implements Comparable<Member> {
    private String id;              // Member ID
    private String name;            // Member name
    private Day joinDate;           // Date member joined
    private int borrowCount;        // Number of current borrows
    private int requestCount;       // Number of pending requests
    private ArrayList<EquipmentSet> borrowedSets;   // Sets currently borrowed

    /** Create new member with ID and name */
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        joinDate = SystemDate.getInstance().clone();
        Club.getInstance().addMember(this);
    }

    /** Display formatted list of all members */
    public static void list(ArrayList<Member> allMembers) {
        System.out.printf("%-5s%-9s%11s%11s%13s\n", "ID", "Name", "Join Date", "#Borrowed", "#Requested");
        for (Member m : allMembers) {
            System.out.printf("%-5s%-9s%11s%7d%13d\n", m.id, m.name, m.joinDate, m.borrowCount, m.requestCount);
        }
    }

    /** Display member's current borrows and requests */
    public void listStatus(ArrayList<Equipment> allEquipments) {
        System.out.printf("[%s %s]\n", id, name);

        ArrayList<String> borrowedRecords = new ArrayList<>();
        ArrayList<String> requestRecords = new ArrayList<>();

        // Collect borrow and request records for all equipment
        for (Equipment equipment : allEquipments) {
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                // Check for current borrows
                if (!set.isAvailableForBorrow() && set.getCurrentBorrower().equals(id)) {
                    String record = String.format("borrows %s (%s) for %s to %s",
                            set.getSetCode(),
                            equipment.getName(),
                            set.getBorrowStartDate(),
                            set.getBorrowEndDate());
                    borrowedRecords.add(record);
                }

                // Check for pending requests
                ArrayList<Day> requestStartDates = set.getRequestStartDate();
                ArrayList<Day> requestEndDates = set.getRequestEndDate();
                ArrayList<String> requestMembers = set.getRequestMembers();

                for (int i = 0; i < requestMembers.size(); i++) {
                    if (requestMembers.get(i).equals(id)) {
                        String record = String.format("requests %s (%s) for %s to %s",
                                set.getSetCode(),
                                equipment.getName(),
                                requestStartDates.get(i),
                                requestEndDates.get(i));
                        requestRecords.add(record);
                    }
                }
            }
        }

        // Display borrow records
        if (!borrowedRecords.isEmpty()) {
            for (String record : borrowedRecords) {
                System.out.println("- " + record);
            }
        }

        // Display request records
        if (!requestRecords.isEmpty()) {
            for (String record : requestRecords) {
                System.out.println("- " + record);
            }
        }

        if (borrowedRecords.isEmpty() && requestRecords.isEmpty())
            System.out.println("No record.");

        System.out.println();
    }

    /** Get member name */
    public String getName() {
        return name;
    }

    /** Get member ID */
    public String getID() {
        return id;
    }

    /** Increment borrow count */
    public void incrementBorrowCount() {
        borrowCount++;
    }

    /** Decrement borrow count */
    public void decrementBorrowCount() {
        borrowCount--;
    }

    /** Increment request count */
    public void incrementRequestCount() {
        requestCount++;
    }

    /** Decrement request count if positive */
    public void decrementRequestCount() {
        if (requestCount > 0) {
            requestCount--;
        }
    }

    /** Compare members by ID for sorting */
    @Override
    public int compareTo(Member another) {
        if (this.id.equals(another.id)) return 0;
        else if (this.id.compareTo(another.id) > 0) return 1;
        else return -1;
    }
}
