package CS2312.lab.week8.Q6;

public class Fire extends RecordedCommand {

    private String name;
    private Company company;
    private int annualLeaves;
    private int salary;
    private Employee e;

    @Override
    public void execute(String[] cmdParts) {
        name = cmdParts[1];
        company = Company.getInstance();
        e = company.findEmployee(name);
        annualLeaves = e.getAnnualLeaves();
        salary = e.getSalary();

        company.removeEmployee(e);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        company.addEmployee(e);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        company.removeEmployee(e);
        addUndoCommand(this);
    }
}
