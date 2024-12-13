package CS2312.lab.week8.Q2;

public class ListAllRecords implements Command {
    @Override
    public void execute(String[] cmdParts) {
        Company company = Company.getInstance();
        company.listEmployees();
    }
}
