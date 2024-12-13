package CS2312.lab.week1.Q6B;

public class Group {

    int TotalMoney = 0;

    Customer[] customerList = new Customer[10];
    int numberOfCustomers = 0;

    public Group() {

    }

    public void add(Customer c) {
        this.TotalMoney += c.getAmount();
        customerList[numberOfCustomers] = c;
        numberOfCustomers++;
    }

    public void spend(int value) {
        TotalMoney -= value;
        for (Customer c : customerList) {
            if (c != null) {
                c.spend(value / numberOfCustomers);
            }
        }
    }
}
