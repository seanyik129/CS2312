package CS2312.lab.week8.Q6;

public class Employee {
    private String name;
    private int salary;
    private int annualLeaves;

    public Employee(String n, int s, int al) {
        name = n;
        salary = s;
        annualLeaves = al;
    }

    public String getName() {
        return name;
    }

    public int getAnnualLeaves() {
        return annualLeaves;
    }

    public void addSalary(int inc) {
        salary+=inc;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " ($" + salary + ", " + annualLeaves + " days)";
    }

    public void setAnnualLeaves(int al) {
        annualLeaves = al;
    }

    public void setSalary(int s) {
        salary = s;
    }
}
