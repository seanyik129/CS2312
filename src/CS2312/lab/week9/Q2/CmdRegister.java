package CS2312.lab.week9.Q2;

public class CmdRegister extends RecordedCommand {

    private Club c;
    private String name;
    private String id;

    @Override
    public void execute(String[] cmdParts) {
        c = Club.getInstance();
        id = cmdParts[1];
        name = cmdParts[2];
        new Member(id, name);
        addUndoCommand(this); //<====== store this command (addUndoCommand is implemented in RecordedCommand.java)
        clearRedoList(); //<====== There maybe some commands stored in the redo list.  Clear them.

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        c.removeMember(c.findMember(name));
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        new Member(id, name);
        addUndoCommand(this);
    }
}
