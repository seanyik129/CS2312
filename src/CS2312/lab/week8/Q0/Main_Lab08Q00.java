package CS2312.lab.week8.Q0;

import java.util.*;

class Pocket
{
    //Instance field (Note: Object fields are first initialized to null by java)
    private Object thing;

    //Static arraylist
    private static ArrayList<Pocket> createdPockets=new ArrayList<>();

    //Constructor
    public Pocket(Object t) {
        this.thing=t;
        createdPockets.add(this);
    }

    @Override
    public String toString() {return thing.toString();}



    public static void listEverything()
    {
        for (Object p : createdPockets)
            System.out.println(p);
    }

}

public class Main_Lab08Q00 {

    public static void main(String [] args)
    {
        new Pocket("Pencil");
        new Pocket(2014);
        new Pocket("Spring");

        Pocket.listEverything();
    }
}