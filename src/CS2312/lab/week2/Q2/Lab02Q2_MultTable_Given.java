package CS2312.lab.week2.Q2;

import java.util.Scanner;

public class Lab02Q2_MultTable_Given {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int width, height;
        System.out.println("Input the width of the multiplication table (2‐10): ");
        width = sc.nextInt();

        System.out.println("Input the height of the multiplication table (2‐10): ");
        height = sc.nextInt();

        sc.close();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.printf("%5d|", i * j);

            }
            System.out.println();
        }

/* Notes to students:
1. We need a Scanner object to get user input (like Lab01‐Q1 in Lab01.pdf Page 3):
‐ Add the import statement at the beginning: import java.util.*;
‐ Declare a scanner object: Scanner [object variable name];
‐ Create a scanner object as: new Scanner(System.in);
‐ To read an integer, we call the .nextInt() method: [scanner object].nextInt(); ‐ Close the scanner object: [scanner object].close();
2. Learn from Q1: System.out.printf("%5d", x); // Show x, "%" means a field, // right aligned, width=5,
*/
    }
}