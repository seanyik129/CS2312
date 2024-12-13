package CS2312.midterm.Q2;

class A {
    public int value = 500;

    public int getValue() {
        return value;
    }

    public int algorithm() {
        return this.getValue() - this.value;
    }
}


class B extends A {
    public int value = 300;

    public int getValue() {
        return value;
    }

    public int algorithm() {
        return super.algorithm();
    }
}


public class Main {
    public static void main(String[] args) {
        A x = new B();
        System.out.println(x.value); // Statement I
        System.out.println(((B) x).value); // Statement II
        System.out.println(x.getValue()); // Statement III
        System.out.println(((B) x).getValue()); // Statement IV
        System.out.println(x.algorithm()); // Statement V
    }
}
