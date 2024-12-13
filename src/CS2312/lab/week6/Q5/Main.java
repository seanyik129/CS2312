package CS2312.lab.week6.Q5;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static ArrayList<String> extractPath(String path) {
        ArrayList<String> list = new ArrayList<>();
        int preIndex = 0;
        while (preIndex < path.length()) {
            int currIndex = path.indexOf(".txt", preIndex) + 4;

            if (currIndex == 3) {
                break;
            }

            list.add(path.substring(preIndex, currIndex));

            preIndex = currIndex + 1;
        }

//        System.out.println(list);
        return list;
    }

    public static void main(String [] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Please input the file pathname of each team: ");
        ArrayList<String> pathList = extractPath(in.nextLine());

        ArrayList<Team> teamList = new ArrayList<>();

        for (int i = 0; i < pathList.size(); i++) {
            teamList.add(new Team(pathList.get(i)));
        }

        System.out.println("Listing of teams:");
        for (int i = 0; i < teamList.size(); i++) {
            System.out.print("[Team " + (i + 1) + "] " + teamList.get(i).getMemberCount() + " members: ");
            System.out.println(teamList.get(i).getStringOfAllMembers());
        }

        System.out.print("Enter a name for searching: ");
        String name = in.next();
        in.close();
        for (int i = 0; i < teamList.size(); i++) {
            Role result = teamList.get(i).printSearchingResult(name);
            if (result != null) {
                if (result instanceof RLeader) {
                    System.out.println("Result: " + name + " is the leader in Team " + (i + 1));
                } else if (result instanceof RDisappeared) {
                    System.out.println("Result: " + name + " is a disappeared member in Team " + (i + 1));
                } else {
                    System.out.println("Result: " + name + " is a normal member in Team " + (i + 1));
                }
                return;
            }
        }

        System.out.println("Result: Not found");
    }
}

