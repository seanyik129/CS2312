package CS2312.assignment.assignment;

import java.util.ArrayList;

public class CmdListEquipmentStatus implements Command {

    /** Execute list status command - display status of all equipment sets */
    @Override
    public void execute(String[] cmdParts) {
        Club club = Club.getInstance();
        ArrayList<Equipment> equipments = club.getAllEquipments();

        for (Equipment equipment : equipments) {
            equipment.listStatus();
        }
    }
}
