package CS2312.lab.week1.Q6A;

public class Shop {

    private int totalProfit = 0;

    public void earn(Customer c, int value) {
        totalProfit += value;
        c.spend(value);
    }

    public int getProfit() {
        return totalProfit;
    }



}
