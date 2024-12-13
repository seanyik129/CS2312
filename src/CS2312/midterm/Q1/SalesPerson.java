package CS2312.midterm.Q1;

import java.util.*;

public class SalesPerson {
    private ArrayList<Product> soldList;

    public SalesPerson() {
        soldList = new ArrayList<>();
    }

    public void sell(Product p) {
        soldList.add(p);
    }

    public void showEarnFrom(Company c) {
        int count = 0;

        for (Product p : soldList) {
            if (p.getCompany() == c) {
                count++;
            }
        }

        System.out.println(count + " points");
    }
}
