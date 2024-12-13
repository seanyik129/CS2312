package CS2312.lab.week9.Q2;

public class CmdListMembers implements Command {
    @Override
    public void execute(String[] cmdParts) {
        Club.getInstance().listClubMembers();
    }
}
