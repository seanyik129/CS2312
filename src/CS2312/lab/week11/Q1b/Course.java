package CS2312.lab.week11.Q1b;//package CS2312.lab.week11.Q1a;

import java.util.ArrayList;

public class Course {

    final private String code;
    ArrayList<Offering> offerings = new ArrayList<>();

    public Course(String code) {
        this.code = code;
    }

    public void addOffering(String semester) {
        offerings.add(new Offering(semester));
    }

    public Offering findOffering(String semester) {
        return Offering.findOffering(offerings, semester);
    }

    public void listStudents() {
        for (Offering o : offerings) {
            o.listStudents();
        }
    }

}
