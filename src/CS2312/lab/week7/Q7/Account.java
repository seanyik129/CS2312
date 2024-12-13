package CS2312.lab.week7.Q7;

abstract public class Account {
    /*
Add the class called Account

Given code for strings:
	public String toString()
	{
		return "Bank A/C Number: "+getAccountNumber();
	}

*/
    private String account_no;

    public Account(String ano) {
        this.account_no = ano;
    }

    public abstract double getTotal();

    public String getAccountNumber() {
        return account_no;
    }


    public String toString() {
        return "Bank A/C Number: " + getAccountNumber();
    }
}
