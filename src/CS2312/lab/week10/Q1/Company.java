package CS2312.lab.week10.Q1;

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

    public Employee findEmployee(String name) throws ExEmployeeNotFound {
        for (Employee e : allEmployees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }

        throw new ExEmployeeNotFound();
    }

    public void addEmployee(Employee e) {
        allEmployees.add(e);
    }
}
