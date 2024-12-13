package CS2312.lab.week5.Q6a_and_b;

public class AreaCounter extends Counter
{
    private String areaName;

    public AreaCounter(String areaName)
    {
        this.areaName = areaName;
    }

    public void countData(Record r) {
        if (r.getArea().equals(areaName))
            super.countData(r);
    }

    @Override
    public String toString()
    {
        return String.format("[%s area] Count = %d", areaName, getCount());
    }

}
