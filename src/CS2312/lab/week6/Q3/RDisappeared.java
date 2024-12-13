package CS2312.lab.week6.Q3;

public class RDisappeared implements Role {
    public String genTeamContactMsg(Team team)
    {
        Member leader = team.getLeader();
        return "When you are back, please contact your leader: " + leader.getName();
    }

    public String getNameAndRole(Member member) {
        return member.getName() + "[x]";
    }
}
