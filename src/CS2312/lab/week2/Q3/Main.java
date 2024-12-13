package CS2312.lab.week2.Q3;

import java.io.FileNotFoundException; //We will learn exceptions later
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException //We will learn exceptions later
    {
        System.out.print("Please input the file pathname: ");

        Scanner scannerObj = new Scanner(System.in);
        String filePathName = scannerObj.nextLine();

        //Your tasks:
        //  Create a new Table2dMxSumRowCol object and assign it to a variable of Table2dMxSumRowCol
        //      Call its constructor with the filePathName as argument
        Table2dMxSumRowCol table2dMxSumRowCol = new Table2dMxSumRowCol(filePathName);


        //  Then apply the .print(), .getRowSumMax() and
        //      .getColSumMax() methods to finish the work.
        //

        System.out.println("Maximum row sum: " + table2dMxSumRowCol.getRowSumMax());

        System.out.println("Maximum col sum: " + table2dMxSumRowCol.getColSumMax());

        scannerObj.close();
    }

}