package CS2312.lab.week11.Q1b;//package CS2312.lab.week11.Q1a;

import java.util.ArrayList;

public class Offering {

    private String semester;
    private ArrayList<Student> students;

    public Offering(String semester)
    {
        this.semester = semester;
        this.students = new ArrayList<>();
    }

    public static Offering findOffering(ArrayList<Offering> offer, String sem)
    {
        for (Offering o : offer) {
            if (o.semester.equals(sem)) {
                return o;
            }
        }
        return null;
    }

    public String getSemester()
    {
        return semester;
    }

    public void listStudents() {
        System.out.print(semester + ": ");
        System.out.print(Student.getIdList(students));
        System.out.println();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
