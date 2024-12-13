package CS2312.lab.week5.Q6a_and_b;

public class AgeGroupCounter extends Counter {
    private int ageGroup1;
    private int ageGroup2;

    public AgeGroupCounter(int ageGroup1, int ageGroup2)
    {
        this.ageGroup1 = ageGroup1;
        this.ageGroup2 = ageGroup2;
    }

    public void countData(Record r) {
        if (r.getAge() >= ageGroup1 && r.getAge() <= ageGroup2)
            super.countData(r);
    }

    @Override
    public String toString()
    {
        return String.format("[Age %d to %d] Count = %d", ageGroup1, ageGroup2, getCount());
    }
}
