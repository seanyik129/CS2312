package CS2312.assignment.assignment;

public class CmdListMembers implements Command {

    /** Execute list members command - display all club members */
    @Override
    public void execute(String[] cmdParts) {
        Club.getInstance().listClubMembers();
    }
}