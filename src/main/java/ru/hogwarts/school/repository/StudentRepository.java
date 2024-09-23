package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeBetween(int startAge, int endAge);

    Optional<Student> findById(long id);

    @Query(value = "SELECT count(id) FROM students", nativeQuery = true)
    Integer getAllByStudent();

    @Query(value = "select avg(age) from students ", nativeQuery = true)
    Integer averageAge();

    @Query(value = "select *from students order by id desc limit 5", nativeQuery = true)
    List<Student> getLastStudents();
}
