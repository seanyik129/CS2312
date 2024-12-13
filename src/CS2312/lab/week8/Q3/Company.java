package CS2312.lab.week8.Q3;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> allEmployees;

    final private static Company instance = new Company();

    public static Company getInstance() {
        return instance;
    }

    private Company() {
        allEmployees = new ArrayList<>();
    }

    public void listEmployees() {
        for (Employee e : allEmployees) {
            System.out.println(e);
        }
    }

    public Employee findEmployee(String name) {
        for (Employee e : allEmployees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }

        return null;
    }

    public void addEmployee(Employee e) {
        allEmployees.add(e);
    }
}
