package az.et.lesson13.repository;

import az.et.lesson13.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByName(String name);

    Optional<StudentEntity> findByNameAndAge(String name, int age);

}
