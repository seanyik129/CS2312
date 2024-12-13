package CS2312.lab.week8.Q3;

public class ChangeAnnualLeaves extends RecordedCommand {

    private Employee e;
    private int days;
    private int originalDays;

    @Override
    public void execute(String[] cmdParts) {
        Company company = Company.getInstance();
        e = company.findEmployee(cmdParts[1]);
        originalDays = e.getAnnualLeaves();
        days = Integer.parseInt(cmdParts[2]);


        e.setAnnualLeaves(days);

        addUndoCommand(this);

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        e.setAnnualLeaves(originalDays);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        e.setAnnualLeaves(days);
        addUndoCommand(this);
    }
}
