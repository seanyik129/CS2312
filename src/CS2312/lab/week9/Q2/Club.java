package CS2312.lab.week9.Q2;

import java.util.ArrayList;
import java.util.Collections;

public class Club {
    private ArrayList<Member> allMembers;
    private static Club instance = new Club();// Instance created when the class is loaded.

    private Club() {allMembers = new ArrayList<>();}

    public static Club getInstance() {
        return instance;
    }

    public void addMember(Member m) {// See how it is called in Member constructor (Step 3)
        allMembers.add(m);
        Collections.sort(allMembers); // allMembers
    }

    public void removeMember(Member m) {
        allMembers.remove(m); //.remove is a method of ArrayList
    }

    public Member findMember(String id) {
        for (Member m : allMembers) {
            if (m.getName().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public void listClubMembers() {
        Member.list(this.allMembers);
    }
}
