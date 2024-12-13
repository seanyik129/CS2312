package CS2312.assignment.assignment;

import java.util.ArrayList;

public class CmdListMemberStatus implements Command {

    /** Execute list status command - display borrowing status of all members */
    @Override
    public void execute(String[] cmdParts) {
        Club club = Club.getInstance();
        ArrayList<Member> members = club.getAllMembers();
        ArrayList<Equipment> equipments = club.getAllEquipments();

        for (Member member : members) {
            member.listStatus(equipments);
        }
    }
}
