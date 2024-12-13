package CS2312.lab.week12.Q3;

public abstract class Animal implements Runnable {
    final private String name;
    final private int runSpeed;
    public Animal(String name, int runSpeed) {
        this.name = name;
        this.runSpeed = runSpeed;
    }

    @Override
    public String getMyName() {
        return name;
    }

    @Override
    public int getRunSpeed() {
        return runSpeed;
    }
}
