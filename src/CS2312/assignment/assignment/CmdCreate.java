package CS2312.assignment.assignment;

public class CmdCreate extends RecordedCommand {

    private Club club;      // The club instance
    private String name;    // Equipment name
    private String code;    // Equipment code

    /** Execute create command - create new equipment record */
    @Override
    public void execute(String[] cmdParts) {
        try {
            club = Club.getInstance();
            code = cmdParts[1];
            if (club.findEquipment(code) != null) {
                throw new ExDuplicateEquipmentCode("Equipment code already in use: " + code + " " + club.findEquipment(code).getName());
            }
            name = cmdParts[2];
            new Equipment(code, name);
            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        } catch (ExDuplicateEquipmentCode e) {
            System.out.println(e.getMessage());
        }
    }

    /** Undo create command - remove the created equipment */
    @Override
    public void undoMe() {
        club.removeEquipment(club.findEquipment(code));
        addRedoCommand(this);
    }

    /** Redo create command - recreate the removed equipment */
    @Override
    public void redoMe() {
        new Equipment(code, name);
        addUndoCommand(this);
    }
}