package CS2312.lab.week4.Q11;

import java.util.*;

public class MainQ11reverse
{
	
	// Return an integer that is the reversed version of the input integer x (without the 0 digit). eg. 1234=>4321
	public static int reverse(int x) {
		if (x < 10) {
			return x;
		} else {
			return (x % 10) * (int)Math.pow(10, (int)Math.log10(x)) + reverse(x / 10);
		}
	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(reverse(x));
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}
