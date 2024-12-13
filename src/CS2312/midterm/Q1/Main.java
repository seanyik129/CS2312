package CS2312.midterm.Q1;

public class Main {
    public static void main(String[] args) {
        Company a = new Company();
        Company b = new Company();
        Company c = new Company();

        Product p1 = a.launch();
        Product p2 = b.launch();
        Product p3 = c.launch();
        Product p4 = c.launch();

        SalesPerson ada = new SalesPerson();
        SalesPerson paul = new SalesPerson();

        ada.sell(p1); //earn one commission point from company a
        ada.sell(p3); //earn one commission point from company c
        ada.sell(p3); //earn one commission point from company c
        ada.sell(p4); //earn one commission point from company c

        ada.showEarnFrom(a); //Output: 1 points
        ada.showEarnFrom(b); //Output: 0 points
        ada.showEarnFrom(c); //Output: 3 points
        paul.showEarnFrom(a); //Output: 0 points
        paul.showEarnFrom(b); //Output: 0 points
        paul.showEarnFrom(c); //Output: 0 points
    }
}
