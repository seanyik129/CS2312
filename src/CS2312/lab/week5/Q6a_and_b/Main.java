package CS2312.lab.week5.Q6a_and_b;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Read input file pathname
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the filename: ");
        String filepathname = in.next();

        //Grab the StatisticsSystem ss and add counters
        StatisticsSystem ss = StatisticsSystem.getInstance();

        ss.addCounter(new Counter());

        // /*Now removed*/ ss.addCounter(new AreaCounter("YuenLong"));
        // /*Now removed*/ ss.addCounter(new AreaCounter("KwunTong"));

        in.nextLine(); // There is now a '\n' in the input stream, skip it: in.nextLine();
        System.out.print("\nEnter the area names (e.g. TaiPo YuenLong WongTaiSin KwunTong): ");
        String line = in.nextLine(); //Read a line: in.nextLine();
        Scanner scannerLine = new Scanner(line); //Create the scanner for input from the string: new Scanner(line);
        while (scannerLine.hasNext()) //Still have contents or not: hasNext()
            ss.addCounter(new AreaCounter(scannerLine.next())); //Area name is grabbed from the string: scannerLine.next()
        scannerLine.close(); //Close the scanner: close();

        System.out.println();

        int age1 = 0;
        int age2 = 0;

        do {
            System.out.print("\nEnter the age groups ('-1 -1' to end): ");
            age1 = in.nextInt();
            age2 = in.nextInt();
            if (age1 == -1 && age2 == -1) break;
            ss.addCounter(new AgeGroupCounter(age1, age2));
        } while (age1 != -1);


        //The ss will load file data and tell its counters to count
        ss.countData(filepathname);

        //The ss will tell its counters to report
        ss.report();

        in.close();
    }
}