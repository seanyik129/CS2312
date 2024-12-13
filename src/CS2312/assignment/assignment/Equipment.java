package CS2312.assignment.assignment;

import java.util.ArrayList;
import java.util.Collection;

public class Equipment implements Comparable<Equipment> {
    private String code;    // Unique identifier code
    private String name;    // Equipment name
    private ArrayList<EquipmentSet> equipmentSets;    // List of equipment sets

    /** Create new equipment with given code and name */
    public Equipment(String id, String name) {
        this.code = id;
        this.name = name;
        Club.getInstance().addEquipment(this);
        equipmentSets = new ArrayList<>();
    }

    /** Display list of equipment with availability info */
    public static void list(ArrayList<Equipment> allEquipments) {
        System.out.printf("%-5s%-20s%7s\n", "Code", "Name", "#Sets");
        for (Equipment equipment : allEquipments) {
            System.out.printf("%-5s%-20s%5d", equipment.code, equipment.name, equipment.equipmentSets.size());

            ArrayList<String> borrowedSets = new ArrayList<>();
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                if (!set.isAvailableForBorrow()) {
                    borrowedSets.add(String.format("%s(%s)", set.getSetCode(), set.getCurrentBorrower()));
                }
            }

            if (!borrowedSets.isEmpty()) {
                System.out.print("  (Borrowed set(s): " + String.join(", ", borrowedSets) + ")");
            }

            System.out.println();
        }
    }

    /** Get equipment name */
    public String getName() {
        return name;
    }

    /** Get equipment code */
    public String getCode() {
        return code;
    }

    /** Compare equipment based on code */
    @Override
    public int compareTo(Equipment o) {
        return this.code.compareTo(o.code);
    }

    /** Add new equipment set */
    public void arriveSet() {
        String setCode = code + "_" + (equipmentSets.size() + 1);
        equipmentSets.add(new EquipmentSet(setCode));
    }

    /** Get list of equipment sets */
    public ArrayList<EquipmentSet> getEquipmentSets() {
        return equipmentSets;
    }

    /** Remove equipment set with given code */
    public void removeSet(String setCode) {
        EquipmentSet toRemove = null;
        for (EquipmentSet set : equipmentSets) {
            if (set.getSetCode().trim().equalsIgnoreCase(setCode.trim())) {
                toRemove = set;
                break;
            }
        }

        equipmentSets.remove(toRemove);
    }

    /** Display detailed status of equipment and its sets */
    public void listStatus() {
        System.out.printf("[%s %s]\n", code, name);

        if (equipmentSets.isEmpty()) {
            System.out.println("  We do not have any sets for this equipment.");
        } else {
            for (EquipmentSet set : equipmentSets) {
                System.out.printf("  %s\n", set.getSetCode());
                if (set.isAvailableForBorrow()) {
                    System.out.println("    Current status: Available");
                } else {
                    System.out.printf("    Current status: %s %s borrows for %s to %s\n",
                            set.getCurrentBorrower(),
                            Club.getInstance().findMember(set.getCurrentBorrower()).getName(),
                            set.getBorrowStartDate(),
                            set.getBorrowEndDate());
                }

                ArrayList<Day> requestStartDate = set.getRequestStartDate();
                ArrayList<Day> requestEndDate = set.getRequestEndDate();
                ArrayList<String> requestMembers = set.getRequestMembers();
                if (!requestStartDate.isEmpty()) {
                    System.out.print("    Requested period(s): ");
                    for (int i = 0; i < requestStartDate.size(); i++) {
                        System.out.printf("%s to %s",
                                requestStartDate.get(i),
                                requestEndDate.get(i));
                        if (i < requestStartDate.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
}