package az.et.lesson13.service;

import az.et.lesson13.model.Student;
import az.et.lesson13.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public Student findByName(String name) {
        return studentRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Student with name: " + name + " not found!"));
    }

    public Student createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

}
