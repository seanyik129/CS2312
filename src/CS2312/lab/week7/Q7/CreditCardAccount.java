package CS2312.lab.week7.Q7;

public class CreditCardAccount extends Account {
    /*
Add the class called CreditCardAccount
It should extend the superclass: Account

Given code for strings:
 return "Credit Card A/C Number: "+____________+
				" Balance: $"+String.format("%.2f",____________)+
				" Credit limit: $"+String.format("%.2f",____________);

*/
    private double balance;
    private double creditLimit;

    public CreditCardAccount (String ano, double bal, double climit) {
        super(ano);
        this.balance = bal;
        this.creditLimit = climit;
    }

    @Override
    public double getTotal() {
        return balance;
    }

    public String toString()
    {
        return "Credit Card A/C Number: " + getAccountNumber() +
                " Balance: $"+String.format("%.2f",balance)+
                " Credit limit: $"+String.format("%.2f",creditLimit);
    }
}
