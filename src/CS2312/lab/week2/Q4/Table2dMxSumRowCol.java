package CS2312.lab.week2.Q4;

import java.io.*; //For file I/O
import java.util.*;

public class Table2dMxSumRowCol
{

    //(1) Add the instance field, nums, for the 2D array here
    // (Answer is in Given_Code.txt!!)
    private int[][] nums;

    //Constructor
    public Table2dMxSumRowCol(String filepathname) throws FileNotFoundException //learn exceptions later
    {
        //Part I. Create the 2D array
        // (2) nums = ____________
        nums = new int[10][10];
        // (Answer is in Given_Code.txt!!)

        //Part II. Perform file reading and insert values into the 2D array
        Scanner inFile;
        //(3) construct the scanner object for file reading
        // (Answer is in Given_Code.txt!!)
        inFile = new Scanner(new File(filepathname));
        //
        //
        // (4) read the file until the end and add values
        while (inFile.hasNextInt())
        {
            //(5) read the next integer from the file and add it to the 2D array
            // (Answer is in Given_Code.txt!!)
            int row, col, value;
            row = inFile.nextInt();
            col = inFile.nextInt();
            value = inFile.nextInt();
            nums[row][col] = value;

        }
        // (Answer is in Given_Code.txt!!)
        //
        //
        inFile.close();
    }

    public void print() {

        /* For each row, we print the columns in that row.

           Note: row and column are easily mixed up.
            To avoid careless mistake, readability is important.
            Use meaningful variable names like row,col or r,c, or y,x etc.
            Do not use i,j.
        */

        for (int row=0; row<10; row++)
        {
            for (int col=0; col<10; col++)
            {
                System.out.print("\t"+nums[row][col]); //separated by tabs
            }
            System.out.println();
        }
    }

    //Return the maximum sum among the rows
    public int getRowSumMax(){
        //Your task: implement this method
        int max = 0;
        for (int row=0; row<10; row++) {
            int sum = 0;
            for (int col=0; col<10; col++) {
                sum += nums[row][col];
            }
            if (sum > max) {
                max = sum;
            };
        }
        return max; //This is temporary!!  You may finish this method in next step.
    }

    public int getColSumMax() {
        int max = 0;
        for (int col=0; col<10; col++) {
            int sum = 0;
            for (int row=0; row<10; row++) {
                sum += nums[row][col];
            }
            if (sum > max) {
                max = sum;
            };
        }
        return max;
    }

    //
    //Other methods
    //  (See Given_Code.txt!!)
    //

    public void printRowIndex(final int max) {

        //get amount of index that equal to max
        int count = 0;
        for (int row=0; row<10; row++) {
            int sum = 0;
            for (int col=0; col<10; col++) {
                sum += nums[row][col];
            }
            if (sum == max) {
                count++;
            };
        }

        int temp_count = count;
        //init a array which size equal to count
        int[] rowIndex = new int[count];

        //get and save the index to rowIndex array
        for (int row=0; row<10; row++) {
            int sum = 0;
            for (int col=0; col<10; col++) {
                sum += nums[row][col];
            }
            if (sum == max) {
                rowIndex[temp_count - 1] = row;
                temp_count--;
            };
        }

        //reverse rowIndex
        int start = 0;
        int end = count - 1;
        while (start < end && count > 2) {
            int temp = rowIndex[start];
            rowIndex[start] = rowIndex[end];
            rowIndex[end] = temp;

            start++;
            end--;
        }

        //reverse colIndex
        if (count == 2) {
            int temp = rowIndex[0];
            rowIndex[0] = rowIndex[1];
            rowIndex[1] = temp;
        }

        System.out.print(" (row ");

        for (int i = 0; i < rowIndex.length; i++) {
            if (i + 1 < rowIndex.length)
                System.out.print(rowIndex[i] + ",");
            else {
                System.out.print(rowIndex[i]);
            }
        }

        System.out.println(")");
    }

    public void printColIndex(final int max) {

        //get amount of index that equal to max
        int count = 0;
        for (int col=0; col<10; col++) {
            int sum = 0;
            for (int row=0; row<10; row++) {
                sum += nums[row][col];
            }
            if (sum == max) {
                count++;
            };
        }

        int temp_count = count;
        //init a array which size equal to count
        int[] colIndex = new int[count];

        //get and save the index to colIndex array
        for (int col=0; col<10; col++) {
            int sum = 0;
            for (int row=0; row<10; row++) {
                sum += nums[row][col];
            }
            if (sum == max) {
                colIndex[temp_count - 1] = col;
                temp_count--;
            };
        }

        //reverse colIndex
        int start = 0;
        int end = count - 1;
        while (start < end && count > 2) {
            int temp = colIndex[start];
            colIndex[start] = colIndex[end];
            colIndex[end] = temp;

            start++;
            end--;
        }

        //reverse colIndex
        if (count == 2) {
            int temp = colIndex[0];
            colIndex[0] = colIndex[1];
            colIndex[1] = temp;
        }

        System.out.print(" (col ");

        for (int i = 0; i < colIndex.length; i++) {
            if (i + 1 < colIndex.length)
                System.out.print(colIndex[i] + ",");
            else {
                System.out.print(colIndex[i]);
            }
        }

        System.out.println(")");
    }

}