package CS2312.lab.week7.Q7;

public class SavingsAccount extends Account{
    /*
Add the class called SavingsAccount
It should extend the superclass: Account

Given code for strings:
 return "Savings A/C Number: "+_________________+
				" Balance: $"+String.format("%.2f",______________);

*/
    public SavingsAccount(String ano, double bal) {
        super(ano);
        balance = bal;
    }

    private double balance;

    @Override
    public double getTotal()
    {
        return balance;
    }

    public String toString() {
        return "Savings A/C Number: " + getAccountNumber() +
                " Balance: $" + String.format("%.2f", getTotal());
    }


}
