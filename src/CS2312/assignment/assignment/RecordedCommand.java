package CS2312.assignment.assignment;

import java.util.ArrayList;

/** Abstract class for commands that can be undone/redone */
public abstract class RecordedCommand implements Command {

    /** Undo this command */
    public abstract void undoMe();

    /** Redo this command */
    public abstract void redoMe();

    // Lists to track undo/redo commands
    private static final ArrayList<RecordedCommand> undoList = new ArrayList<>();
    private static final ArrayList<RecordedCommand> redoList = new ArrayList<>();

    /** Add command to undo list */
    protected static void addUndoCommand(RecordedCommand cmd) {
        undoList.add(cmd);
    }

    /** Add command to redo list */
    protected static void addRedoCommand(RecordedCommand cmd) {
        redoList.add(cmd);
    }

    /** Clear the redo list */
    protected static void clearRedoList() {
        redoList.clear();
    }

    /** Redo most recent undone command */
    public static void redoOneCommand() {
        if (redoList.isEmpty()) {
            System.out.println("Nothing to redo.");
        } else {
            // Remove and execute last command from redo list
            RecordedCommand rc = redoList.remove(redoList.size() - 1);
            rc.redoMe();
        }
    }

    /** Undo most recent command */
    public static void undoOneCommand() {
        if (undoList.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            // Remove and undo last command from undo list
            RecordedCommand rc = undoList.remove(undoList.size() - 1);
            rc.undoMe();
        }
    }
}

