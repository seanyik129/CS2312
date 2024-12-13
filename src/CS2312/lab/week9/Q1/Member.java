package CS2312.lab.week9.Q1;

import java.util.ArrayList;

public class Member implements Comparable<Member> {
    private String id;
    private String name;
    private Day joinDate;

    public Member(String id, String name) {
    //Set id, name, joinDate
        this.id = id;
        this.name = name;
        joinDate = SystemDate.getInstance().clone();
        Club.getInstance().addMember(this);
    }

    public static void list(ArrayList<Member> allMembers) {
        //Learn: "-" means left-aligned
        System.out.printf("%-5s%-9s%11s%11s%13s\n", "ID", "Name",
                "Join Date ", " #Borrowed ", "#Requested");
        for (Member m: allMembers) {
            System.out.printf("%-5s%-9s%11s%7d%13d\n", m.id, m.name,
                    m.joinDate, 0, 0);
        }
    }

    @Override
    public int compareTo(Member another) {
        if (this.id.equals(another.id)) return 0;
        else if (this.id.compareTo(another.id)>0)return 1;
        else return -1;
    }
}
