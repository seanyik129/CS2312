package CS2312.lab.week1.Q6A;

public class Customer {

    private int totalMoney;

    public Customer(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void set(int money) {
        totalMoney = money;
    }

    public void spend(int value) {
        totalMoney -= value;
    }

    public int getAmount() {
        return totalMoney;
    }


}
