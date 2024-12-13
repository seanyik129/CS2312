package CS2312.midterm.Q1;

import java.util.*;

public class Company {
    public Product launch() {
        return new Product(this);
    }
}
