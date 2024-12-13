package CS2312.lab.week12.Q2;

public class Person
{

    public Playable getPlay(String toyName) {
        if (toyName.equals("Football"))
            return new Football();
        else if (toyName.equals("Piano"))
            return new Piano();
        else if (toyName.equals("Chess"))
            return new Chess();
        return null;
    }

}
