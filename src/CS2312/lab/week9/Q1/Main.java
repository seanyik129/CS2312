package CS2312.lab.week9.Q1;

public class Main {

    public static void main(String [] args) {

        SystemDate.createTheInstance("03-Jan-2024");

        new Member("010","helena");
        new Member("012","jason");

        SystemDate.getInstance().set("06-Jan-2024");

        new Member("013","kit");

        Club.getInstance().listClubMembers();
    }
}
