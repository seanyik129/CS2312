package CS2312.lab.week2.Q5.a;

import java.io.*;
import java.util.Scanner;

public class Attendance {

    private int[] students;
    private int[] attendees;

    public Attendance() throws FileNotFoundException {
        students = new int[20];
        attendees = new int[20];
        Scanner sStudents = new Scanner(new File("StudentList.txt"));
        Scanner sAttendees = new Scanner(new File("AttendanceLog.txt"));


        for (int i = 0; i < 20; i++) {
            students[i] = sStudents.nextInt();
            attendees[i] = sAttendees.nextInt();
        }


        sStudents.close();
        sAttendees.close();
    }

    public boolean isPresent(int id) {

        for (int i = 0; i < 20; i++) {
            if (id == students[i]) {
                for (int j = 0; j < 20; j++) {
                    if (id == attendees[j]) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public boolean belongToClass(int id) {

        for (int i = 0; i < 20; i++) {
            if (id == students[i]) {
                return true;
            }
        }

        return false;
    }

    public void listAbsentees() {

        int count = 0;
        int[] temp_students = new int[20];

        for (int i = 0; i < 20; i++) {
            temp_students[i] = students[i];
        }

        System.out.println("List of absentees:");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (students[i] == attendees[j]) {
                    temp_students[i] = -1;
                }
            }
        }

        for (int num : temp_students) {
            if (num != -1) {
                count++;
                System.out.println(num);
            }
        }

        System.out.println("Total count: " + count);

    }

    public void listWalkIn() {
        System.out.println("List of walk-in students:");


        for (int i = 0; i < 20; i++) {
            if (belongToClass(attendees[i])) {
                attendees[i] = -1;
            }
        }

        for (int num : attendees) {
            if (num != -1 && num != 0) {
                System.out.println(num);
            }
        }

    }

}
