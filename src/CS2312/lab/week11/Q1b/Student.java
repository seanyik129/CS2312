package CS2312.lab.week11.Q1b;//package CS2312.lab.week11.Q1a;

import java.util.ArrayList;

public class Student {

    final private String ID;
    private ArrayList<Offering> studies = new ArrayList<>();

    public Student(String ID) {
        this.ID = ID;
    }
    public ArrayList<String> takenCourses;

    public void takeCourse(Course course, String semester) {
        Offering offering = course.findOffering(semester);
        studies.add(offering);
        offering.addStudent(this);
    }

    public boolean hasBeenClassmateOf(Student s2) {
        for (Offering o : this.studies) {
            if (s2.hasTaken(o)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTaken(Offering oSearch) {
        for (Offering o : this.studies) {
            if (o == oSearch) {
                return true;
            }
        }
        return false;
    }

    public static String getIdList(ArrayList<Student> students) {
        String result = "";
        for (Student s : students) {
            result += s.ID + " ";
        }
        return result;
    }

}
