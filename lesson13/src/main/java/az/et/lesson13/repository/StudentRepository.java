package az.et.lesson13.repository;

import az.et.lesson13.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {

    public static final List<Student> STUDENTS = new ArrayList<>(
            Arrays.asList(
                    new Student("Elvin", 21, "CS", Arrays.asList("A", "B", "C")),
                    new Student("Ali", 20, "IT", List.of("A")),
                    new Student("Orxan", 25, "Fizika", Collections.emptyList())
            )
    );

    public List<Student> findAllStudents() {
        return STUDENTS;
    }

    public Optional<Student> findByName(String name) {
        return STUDENTS.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst();
    }

    public Student createStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }
}
