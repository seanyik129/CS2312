package CS2312.lab.week6.Q5;

public class Member
{

    private String name;
    private Role role;

    public Member(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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
