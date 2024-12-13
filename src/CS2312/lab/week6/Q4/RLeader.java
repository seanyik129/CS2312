package CS2312.lab.week6.Q4;

public class RLeader implements Role
{
    public String genTeamContactMsg(Team team) {
        String teammates = team.getStringOfNormalMembers();
        return "Please contact your members: " + teammates;
    }

    public String getNameAndRole(Member member) {
        return member.getName() + "[Leader]";
    }
}
