package CS2312.lab.week1.Q2;

import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        System.out.print("Please enter the date (eg. \"2013 12 31\"): ");
        Scanner scannerObj = new Scanner(System.in);
        int y, m, d;
        y=scannerObj.nextInt();
        m=scannerObj.nextInt();
        d=scannerObj.nextInt();
        if (!CS2312.lab.week1.Q5.Day.valid(y, m, d)) //check whether the input is valid
        {
            System.out.println("Wrong input. Program stopped.");
        }
        else
        {
            CS2312.lab.week1.Q5.Day dayObj = new CS2312.lab.week1.Q5.Day(y,m,d); //create a Day object for the in
            System.out.println("\nYou have entered " + dayObj.toString());
            if (CS2312.lab.week1.Q5.Day.isLeapYear(y))
                System.out.println("It is a Leap Year.");
            else
                System.out.println("It is NOT a Leap Year.");
            if (dayObj.isEndOfAMonth())
                System.out.println("It is the end of a month.");
            else
                System.out.println("It is NOT the end of a month.");
            CS2312.lab.week1.Q5.Day dayObj2 = dayObj.next(); // Here, .next() creates another
            System.out.println("\nThe next day is " + dayObj2.toString());

        }
        scannerObj.close();
    }
}