package CS2312.lab.week4.Q8;

import java.util.*;

public class MainQ08containNonDecreasingDigits
{

    // Determine whether integer x contains non-decreasing digits (eg. 1234, 14789, 224466)
    //i.e., whether the sequence of digits is "sorted" in ascending order.
    static boolean containNonDecreasingDigits(int x)
    {
        if (x < 10) {
            return true;
        }

        int digit = x % 10;
        if (digit < (x / 10 % 10)) {
            return false;
    }

        return containNonDecreasingDigits(x / 10);



    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int x;
        System.out.print("input x (-1 to end) : "); x=s.nextInt();

        while (x!=-1)
        {
            if (containNonDecreasingDigits(x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.print("input x (-1 to end) : "); x=s.nextInt();
        }

        s.close();
    }
}
