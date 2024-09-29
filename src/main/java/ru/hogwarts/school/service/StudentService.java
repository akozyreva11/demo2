package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Value("${student-forecast-service.url}")
    private String url;
    @Value("${student-forecast-service.api-key}")
    private String apiKey;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Info message createStudent");
        return studentRepository.save(student);
    }

    public List<Student> findAgeStudent(int age1, int age2)
    {
        logger.info("Info message findAgeStudent");
        return studentRepository.findByAgeBetween(age1, age2);
    }

    public int getAverageAge() {
        return studentRepository.averageAge();
    }

    public List<Student> getLastStudents() {
        logger.info("Info message getLastStudents");
        return studentRepository.getLastStudents();
    }

    public int findStudentr() {
        logger.info("Info message getAllByStudent");
        return studentRepository.getAllByStudent();
    }

    public Student findStudent(Long id) {
        logger.info("Info message findStudent");
        return studentRepository.getById(id);
    }

    public Student editStudent(Student student) {
        logger.info("Info message editStudent");
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.info("Info message deleteStudent");
        studentRepository.deleteById(id);
    }

    public List<Student> getAge(Integer age) {
        logger.info("Info message getAge");
        return studentRepository.findAll().stream().
                filter(student -> student.getAge() == age).
                collect(Collectors.toList());
    }

}