package CS2312.quiz;

import java.io.*;
import java.util.*;

public class ClassList {

    private Student[] sList;
    private Pair[] pList;

    // DO NOT add any extra object fields

    public ClassList(String fpn) throws FileNotFoundException {

        Scanner in = new Scanner(new File(fpn));

        sList = new Student[10];
        pList = new Pair[5];

        for (int i = 0; i < 10; i++) {
            String name = in.next();
            sList[i] = new Student(name);
        }

        for (int i = 0; i < 5; i++) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            pList[i] = new Pair(sList[num1 - 1], sList[num2 - 1]);
        }


        in.close();

    }


    public void listStudents() {
        System.out.println("Students: ");

        for (int i = 0; i < 10; i++) {
            System.out.printf("[%d] %s\n", i + 1, sList[i].getName());
        }


    }

    public void listPairs() {
        System.out.println("Pairs: ");

        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d] %s %s\n", i + 1, pList[i].getStudent1().getName(),pList[i].getStudent2().getName());
        }

    }

    public void greeting() {
        System.out.println("Greeting messages: ");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (pList[j].getStudent1().getName().equals(sList[i].getName())) {
                    System.out.println("Hi " + pList[j].getStudent2().getName()
                    + ", nice to meet you. I am " + sList[i].getName() + "."
                    );
                } else if (pList[j].getStudent2().getName().equals(sList[i].getName())) {
                    System.out.println("Hi " + pList[j].getStudent1().getName()
                            + ", nice to meet you. I am " + sList[i].getName() + "."
                    );
                }
            }
        }


    }


}
