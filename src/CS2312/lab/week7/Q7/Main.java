package CS2312.lab.week7.Q7;

import java.util.*;
import java.io.*;

public class Main {

    //Add the method called findAccount

    private static Account findAccount(ArrayList<Account> list, String account_no) {
        for (Account a : list) {
            if (account_no.equals(a.getAccountNumber())) {
                return a;
            }
        }

        return null;
    }


    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();

        ArrayList<Account> acs = new ArrayList<>();

        Scanner infile = new Scanner(new File(filepathname));

        while (infile.hasNextLine()) {
            String line = infile.nextLine();
            Scanner sc = new Scanner(line);
            if (line.charAt(0) <= '5' && line.charAt(0) >= '0') {
                acs.add(new SavingsAccount(sc.next(), sc.nextInt()));
            }
            if (line.charAt(0) >= '6' && line.charAt(0) <= '8') {
                acs.add(new CreditCardAccount(sc.next(), sc.nextInt(), sc.nextInt()));
            }
            if (line.charAt(0) == '9') {
                acs.add(new PowerAdvantageAccount(sc.next(), (SavingsAccount) findAccount(acs, sc.next()), (CreditCardAccount) findAccount(acs, sc.next())));
            }
        }


        infile.close();
        System.out.print("\nInput an account number to search: ");

        String accountNumber = in.nextLine();

        Account ac = findAccount(acs, accountNumber);

        if (ac != null) {
            if (ac instanceof SavingsAccount) {
                System.out.print("\n[Result]\n" + ac);
            } else if (ac instanceof CreditCardAccount) {
                System.out.print("\n[Result]\n" + ac);
            } else if (ac instanceof PowerAdvantageAccount) {
                System.out.print("\n[Result]\n" + ac);
            }

        }
        else {
            System.out.println("\n[Result]\nThe account is not found.");
        }
        in.close();
    }
}
