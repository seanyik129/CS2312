package CS2312.lab.week2.Q3;

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

}