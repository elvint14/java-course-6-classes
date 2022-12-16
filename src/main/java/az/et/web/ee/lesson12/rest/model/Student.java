package az.et.web.ee.lesson12.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int age;
    private String name;
    private String group;
    private List<String> courses;

    public Student() {
    }

    public Student(String name, int age, String group) {
        this(name, age, group, new ArrayList<>());
    }

    public Student(String name, int age, String group, List<String> courses) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return String.format("Student[name='%s', age=%d, group='%s', courses=%s]", name, age, group, courses);
    }

}
