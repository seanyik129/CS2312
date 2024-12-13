package CS2312.lab.week7.Q7;

public class PowerAdvantageAccount extends Account {
    /*
Add the class called PowerAdvantageAccount
It should extend the superclass: Account

Given code for strings:
 return "Power Advantage A/C Number: "+____________+" Balance: $"+____________+
				"\n 1."+____________+
				"\n 2."+____________;

*/
    private SavingsAccount savingsAC;
    private CreditCardAccount creditCardAC;

    public PowerAdvantageAccount (String ano, SavingsAccount sa, CreditCardAccount cr) {
        super(ano);
        this.savingsAC = sa;
        this.creditCardAC = cr;
    }

    @Override
    public double getTotal() {
        return savingsAC.getTotal() - creditCardAC.getTotal();
    }

    public String toString()
    {
        return "Power Advantage A/C Number: " + getAccountNumber() + " Balance: $" + String.format("%.2f", getTotal()) +
                "\n 1." + savingsAC +
                "\n 2." + creditCardAC;
    }
}
