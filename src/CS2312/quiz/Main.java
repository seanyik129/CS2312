package CS2312.quiz;

import java.io.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        ClassList c = new ClassList("data.txt");

        c.listStudents();

        c.listPairs();

        c.greeting();
    }
}
