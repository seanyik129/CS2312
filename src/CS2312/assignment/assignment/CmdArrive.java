package CS2312.assignment.assignment;

public class CmdArrive extends RecordedCommand {

    private Club club;          // The club instance
    private String code;        // Equipment code
    private Equipment equipment;// Equipment being processed
    private String lastSetCode; // Code of the last created set

    /** Execute the arrive command - handle new equipment set arrival */
    @Override
    public void execute(String[] cmdParts) {
        try {
            club = Club.getInstance();
            code = cmdParts[1];
            if (club.findEquipment(code) == null) {
                throw new ExMissingEquipmentRecord("Missing record for Equipment " + code + ".  Cannot mark this item arrival.");
            }
            equipment = club.findEquipment(code);
            equipment.arriveSet();

            lastSetCode = code + "_" + equipment.getEquipmentSets().size();

            addUndoCommand(this);
            clearRedoList();

            System.out.println("Done.");
        } catch (ExMissingEquipmentRecord e) {
            System.out.println(e.getMessage());
        }
    }

    /** Undo the arrive command - remove the last added set */
    @Override
    public void undoMe() {
        equipment.removeSet(lastSetCode);
        addRedoCommand(this);
    }

    /** Redo the arrive command - re-add the previously removed set */
    @Override
    public void redoMe() {
        equipment.arriveSet();
        lastSetCode = code + "_" + equipment.getEquipmentSets().size();
        addUndoCommand(this);
    }
}
