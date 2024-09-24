package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAgeStudent(int age1, int age2) {
        return studentRepository.findByAgeBetween(age1, age2);
    }

    public int getAverageAge() {
        return studentRepository.averageAge();
    }

    public List<Student> getLastStudents() {
        return studentRepository.getLastStudents();
    }

    public int findStudentr() {
        return studentRepository.getAllByStudent();
    }

    public Student findStudent(Long id) {
        return studentRepository.getById(id);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAge(Integer age) {
        return studentRepository.findAll().stream().
                filter(student -> student.getAge() == age).
                collect(Collectors.toList());
    }

    public List<String> getStudentsNameFirstA() {
        List<Student> allfio = studentRepository.findAll();

        List<String> allfios = allfio
                .stream()
                .map(Student::getName)
                .filter(name -> name.toUpperCase().startsWith("A"))
                .sorted()
                .toList();

        return allfios;
    }

    public Double getAverageAgeStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0);
    }

    public Integer getSum() {
        return Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, Integer::sum);
    }
}