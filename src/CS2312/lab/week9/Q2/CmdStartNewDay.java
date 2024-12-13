package CS2312.lab.week9.Q2;

public class CmdStartNewDay extends RecordedCommand {

    private String newDay;
    private SystemDate sd;
    private String oldDay;

    @Override
    public void execute(String[] cmdParts) {
        newDay = cmdParts[1];
        sd = SystemDate.getInstance();
        oldDay = sd.toString();
        sd.set(newDay);

        addUndoCommand(this);

        clearRedoList();
        System.out.println("Done.");

    }

    @Override
    public void undoMe() {
        sd.set(oldDay);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        sd.set(newDay);
        addUndoCommand(this);
    }
}
