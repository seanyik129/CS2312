package CS2312.lab.week11.Q1a;

import java.util.ArrayList;

public class Offering {

    private String semester;

    public Offering(String semester)
    {
        this.semester = semester;
    }

    public static Offering findOffering(ArrayList<Offering> offer, String sem)
    {
        for (Offering o : offer) {
            if (o.semester.equals(sem)) {
                return o;
            }
        }
        return null;
    }

}
