package CS2312.assignment.assignment;

import java.util.ArrayList;
import java.util.Collections;

public class Club {
    private ArrayList<Member> allMembers;      // All members of the club
    private ArrayList<Equipment> allEquipments;// All equipment in the club
    final private static Club instance = new Club(); // Single instance of the club

    /** Private constructor to implement Singleton pattern */
    private Club() {
        allMembers = new ArrayList<>();
        allEquipments = new ArrayList<>();
    }

    /** Returns the singleton instance of Club */
    public static Club getInstance() {
        return instance;
    }

    /** Adds a new member to the club and sorts the member list */
    public void addMember(Member member) {
        allMembers.add(member);
        Collections.sort(allMembers);
    }

    /** Adds new equipment to the club and sorts the equipment list */
    public void addEquipment(Equipment equipment) {
        allEquipments.add(equipment);
        Collections.sort(allEquipments);
    }

    /** Removes a member from the club */
    public void removeMember(Member m) {
        allMembers.remove(m);
    }

    /** Finds a member by their ID */
    public Member findMember(String id) {
        for (Member member : allMembers) {
            if (member.getID().equals(id)) {
                return member;
            }
        }
        return null;
    }

    /** Finds equipment by its code */
    public Equipment findEquipment(String code) {
        for (Equipment equipment : allEquipments) {
            if (equipment.getCode().equals(code)) {
                return equipment;
            }
        }
        return null;
    }

    /** Displays list of all club members */
    public void listClubMembers() {
        Member.list(this.allMembers);
    }

    /** Displays list of all club equipment */
    public void listClubEquipments() {
        Equipment.list(this.allEquipments);
    }

    /** Removes equipment from the club */
    public void removeEquipment(Equipment equipment) {
        allEquipments.remove(equipment);
    }

    /** Gets list of all members */
    public ArrayList<Member> getAllMembers() {
        return allMembers;
    }

    /** Gets list of all equipment */
    public ArrayList<Equipment> getAllEquipments() {
        return allEquipments;
    }
}