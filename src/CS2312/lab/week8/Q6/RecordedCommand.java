package CS2312.lab.week8.Q6;

import java.util.ArrayList;

public abstract class RecordedCommand implements Command {

    public abstract void undoMe();
    public abstract void redoMe();

    private static ArrayList<RecordedCommand> undoList = new ArrayList<>();
    private static ArrayList<RecordedCommand> redoList = new ArrayList<>();

    protected static void addUndoCommand(RecordedCommand cmd)
    {
        undoList.add(cmd);
    }

    protected static void addRedoCommand(RecordedCommand cmd)
    {
        redoList.add(cmd);
    }

    protected static void clearRedoList()
    {
        redoList.clear();
    }

    public static void redoOneCommand() {
        if (redoList.size() == 0) {
            System.out.println("Nothing to redo.");
        } else {
            RecordedCommand rc = redoList.remove(redoList.size() - 1);
            rc.redoMe();
        }
    }

    public static void undoOneCommand() {
        if (undoList.size() == 0) {
            System.out.println("Nothing to undo.");
        } else {
            RecordedCommand rc = undoList.remove(undoList.size() - 1);
            rc.undoMe();
        }
    }
}

