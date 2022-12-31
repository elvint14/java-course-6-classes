package az.et.lesson13.service;

import az.et.lesson13.exception.StudentNotFoundException;
import az.et.lesson13.model.Student;
import az.et.lesson13.model.StudentEntity;
import az.et.lesson13.repository.StudentRepo;
import az.et.lesson13.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        List<StudentEntity> allEntities = studentRepo.findAll();
        log.info(allEntities);
        return studentRepository.findAllStudents();
    }

    public Student findByName(String name) {
        Optional<StudentEntity> elvin = studentRepo.findByName("Elvin");
        Optional<StudentEntity> elvin2 = studentRepo.findByNameAndAge("Elvin", 23);
        log.info(elvin);
        log.info(elvin2);
        return studentRepository.findByName(name)
                .orElseThrow(() -> new StudentNotFoundException("Student with name: '" + name + "' not found!"));
    }

    public Student createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    @PostConstruct
    public void populate() {
        studentRepo.save(new StudentEntity("Elvin", 24, "CS"));
    }

}
