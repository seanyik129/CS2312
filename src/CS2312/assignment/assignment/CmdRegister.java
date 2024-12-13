package CS2312.assignment.assignment;

public class CmdRegister extends RecordedCommand {

    private Club club;      // The club instance
    private String name;    // Member name
    private String id;      // Member ID

    /** Execute register command - register new member to club */
    @Override
    public void execute(String[] cmdParts) {
        try {
            club = Club.getInstance();
            id = cmdParts[1];
            if (club.findMember(id) != null) {
                throw new ExDuplicateMemberId("Member ID already in use: " + id + " " + club.findMember(id).getName());
            }
            name = cmdParts[2];
            new Member(id, name);
            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        } catch (ExDuplicateMemberId e) {
            System.out.println(e.getMessage());
        }
    }

    /** Undo register command - remove the registered member */
    @Override
    public void undoMe() {
        club.removeMember(club.findMember(id));
        addRedoCommand(this);
    }

    /** Redo register command - re-register the removed member */
    @Override
    public void redoMe() {
        new Member(id, name);
        addUndoCommand(this);
    }
}
