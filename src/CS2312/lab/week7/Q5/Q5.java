package CS2312.lab.week7.Q5;

class A {
    public int i;
    public static int j;
    public A() {
        i++;
        j++;
    }
    public void fi() {
        i++;
    }
    public void fj() {
        j++;
    }
    public static void sj() {
        j++;
    }

}

class B extends A {
    public int i;
    public static int j;
    public void fi() {
        i++;
    }
    public void fj() {
        j++;
    }
    public static void sj() {
        j++;
    }
}

public class Q5 {
    public static void main(String[] args) {
        A a;
        a = new A();
        a.fi();
        a.fj();
        a.sj();

        B b;
        b = new B();
        b.fi();
        b.fj();
        b.sj();
        System.out.println(a.i + " " + a.j + " " + b.i + " " + b.j);
    }
}
