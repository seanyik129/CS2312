package CS2312.assignment.assignment;

public class CmdListEquipment implements Command {

    /** Execute list equipment command - display all equipment in club */
    @Override
    public void execute(String[] cmdParts) {
        Club.getInstance().listClubEquipments();
    }
}