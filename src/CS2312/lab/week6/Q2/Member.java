package CS2312.lab.week6.Q2;

public class Member
{
    //Instance fields
    private String name;
    private Role role;

    //Constructor
    public Member(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    //Assessor method
    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public String getNameAndRole() {
        return role.getNameAndRole(this);
    }

}
