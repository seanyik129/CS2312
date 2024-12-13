package CS2312.lecture.week3;

class A {
    public void reply() {
        System.out.println("Hi!");
    }
}

class B {
    public void reply() {
        System.out.println("Hey!");
    }
}

class C {
    public void talkTo(A x) {
        System.out.println("Hi A object!");
        x.reply();
    }

    public void talkTo(B x) {
        System.out.println("Hi B object!");
        x.reply();
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        c.talkTo(a);
        c.talkTo(b);
    }
}
