package CS2312.lab.week6.Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Team{

    private Member[] allMembers;

    public Team(String filePathName) throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new File(filePathName));

        int tot = inFile.nextInt();
        inFile.nextLine();
        allMembers = new Member[tot];

        for (int i = 0; i < tot; i++)
        {
            String name = inFile.next();
            char roleType = inFile.next().charAt(0);

            Role r;
            if (roleType == 'l') {
                r = new RLeader();
            }
            else if (roleType == 'n') {
                r = new RNormalMember();
            }
            else r = new RDisappeared();

            allMembers[i]= new Member(name, r);
        }

        inFile.close();
    }

    public int getMemberCount() {
        return allMembers.length;
    }

    public String getStringOfAllMembers() {
        String result="";
        for (int i = 0; i < allMembers.length; i++) {
            result += allMembers[i].getNameAndRole() + " ";
        }
        result=result.trim();
        return result;
    }

    public void printTeamContactMessages()
    {
//        String allNames=getStringOfAllMembers(); //obtains a string like: "Helena Peter Mary Paul"
//        for (int i = 0; i < allMembers.length; i++) //loop for each member
//        {
//            String name_i=allMembers[i].getName(); //e.g. "Helena"
//            System.out.print("Dear " + name_i);
//            String teammates = allNames.replace(name_i, ""); //e.g. "Peter Mary Paul". Use a trick: create a string based on allNames, but remove name_i: allNames.replace(name_i, "");
//            System.out.println(",  please contact your teammates: " + teammates); //teammates
//        }

        {
            for (int i=0;i<allMembers.length;i++)
            {
                String name_i = allMembers[i].getName();
                System.out.print("Dear " + name_i + ",  ");
                String msg = allMembers[i].getRole().genTeamContactMsg(this);
                System.out.println(msg);
            }
        }
    }

    public Member getLeader()
    {
        for (int i=0;i<allMembers.length;i++)
            if (allMembers[i].getRole() instanceof RLeader) {
                return allMembers[i];
            }
        return null;
    }

    public String getStringOfNormalMembers() {
        {
            String result = "";
            for (int i = 0; i < allMembers.length; i++) {
                if (!(allMembers[i].getRole() instanceof RDisappeared) && !(allMembers[i].getRole() instanceof RLeader)) {
                    result += allMembers[i].getNameAndRole() + " ";
                }
            }
            return result.trim();
        }
    }

}