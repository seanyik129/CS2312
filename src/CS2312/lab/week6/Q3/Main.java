package CS2312.lab.week6.Q3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{

    public static void main(String [] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Please input the file pathname: ");

        Team t = new Team(in.nextLine());

        System.out.printf(
                "\nThere are %d members in the team: %s\n\n",
                t.getMemberCount(), t.getStringOfAllMembers());

        System.out.println("Messages for team contacts: ");
        t.printTeamContactMessages();

        in.close();
    }
}

