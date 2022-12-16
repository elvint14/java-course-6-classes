package az.et.web.ee.lesson12.rest.dao;

import az.et.web.ee.lesson12.rest.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDao {

    public static final List<Student> STUDENTS = new ArrayList<>(
            Arrays.asList(
                    new Student("Elvin", 21, "CS", Arrays.asList("A", "B", "C")),
                    new Student("Ali", 20, "IT", Arrays.asList("A")),
                    new Student("Orxan", 25, "Fizika")
            )
    );

}
