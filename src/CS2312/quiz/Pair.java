package CS2312.quiz;


public class Pair {
    private Student s1;
    private Student s2;

    public Pair(Student s1, Student s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public Student getStudent1() {
        return s1;
    }

    public Student getStudent2() {
        return s2;
    }

    // DO NOT add any extra object fields
}
