package CS2312.lab.week5.Q6a_and_b;

public class Counter
{

    private int count = 0;

    public void countData(Record r) {
        //no checking for r in this method
        count++;
    }


    public String toString()
    {
        return String.format("[Total] Count = %d", count);
    }

    protected int getCount() {

        return count;
    }
}