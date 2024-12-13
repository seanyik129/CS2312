package CS2312.lab.week12.Q2;

public class Main
{
    public static void main(String[] args)
    {
        Person person = new Person();

        String[] playables = {
                "Football",
                "Piano",
                "Piano",
                "Football",
                "Chess"
        };

        for (String str : playables)
        {
           person.getPlay(str).play();
        }
    }
}


