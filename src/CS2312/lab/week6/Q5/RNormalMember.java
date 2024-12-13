package CS2312.lab.week6.Q5;

public class RNormalMember implements Role//It should be: public class RNormalMember implements Role
{
    public String genTeamContactMsg(Team team) {
        Member leader = team.getLeader();
        if (leader == null) {
            return "There is no leader in your team.  Please contact your instructor.";
        } else {
            return "Please contact your leader: " + leader.getName();
        }
    }

    public String getNameAndRole(Member member) {
        return member.getName();
    }

}
