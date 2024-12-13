package CS2312.lab.week12.Q4a;

import java.util.ArrayList;
import java.util.List;

public class Programme {

    private List<Course> courseList;
    private AddController addAgent;
    private DropController dropAgent;

    public Programme() {
        courseList = new ArrayList<Course>();
        addAgent = new AddController(courseList);
        dropAgent = new DropController(courseList);
    }

    public void add(Course c) {
        addAgent.process(c);
        addAgent.printCourses();
    }

    public void drop(Course c) {
        dropAgent.process(c);
        dropAgent.printCourses();
    }
}