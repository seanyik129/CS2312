package CS2312.lab.week12.Q3;

public class Cat extends Animal{

    public Cat(String name) {
        super(name, 5);
    }

    public void chase(Runnable m) {

        if (this.getRunSpeed() > m.getRunSpeed()) {
            System.out.println(this.getMyName() + " Catches " + m.getMyName());
        }

        else
            System.out.println(this.getMyName() + " Cannot Catches " + m.getMyName());
    }
}
