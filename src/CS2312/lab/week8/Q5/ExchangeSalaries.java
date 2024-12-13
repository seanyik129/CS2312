package CS2312.lab.week8.Q5;

public class ExchangeSalaries extends RecordedCommand {
    private String e1, e2;
    private int s1, s2;
    private Company company;

    @Override
    public void execute(String[] cmdParts) {
        company = Company.getInstance();
        e1 = cmdParts[1];
        e2 = cmdParts[2];
        s1 = company.findEmployee(e1).getSalary();
        s2 = company.findEmployee(e2).getSalary();
        company.findEmployee(e1).setSalary(s2);
        company.findEmployee(e2).setSalary(s1);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void redoMe() {
        company.findEmployee(e1).setSalary(s2);
        company.findEmployee(e2).setSalary(s1);
        addUndoCommand(this);
    }

    @Override
    public void undoMe() {
        company.findEmployee(e1).setSalary(s1);
        company.findEmployee(e2).setSalary(s2);
        addRedoCommand(this);
    }
}
