package ru.hogwarts.school.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Value("${student-forecast-service.url}")
    private String url;
    @Value("${student-forecast-service.api-key}")
    private String apiKey;

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("addStudent")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student addedStudent = studentService.createStudent(student);
        return ResponseEntity.ok(addedStudent);
    }

    @GetMapping("AllStudent")
    public ResponseEntity<Student> allStudent(@RequestParam Long id) {
        Student newStudent = studentService.findStudent(id);
        if (newStudent == null) {
            logger.error("Info message allStudent не найден");
            return ResponseEntity.notFound().build();
        }
        logger.info("Info message allStudent найден");
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("find")
    public ResponseEntity<Student> getStudents(@RequestParam Long id) {
        Student newStudent = studentService.findStudent(id);
        if (newStudent == null) {
            logger.warn("Info message getStudents не найден");
            return ResponseEntity.notFound().build();
        }
        logger.info("Info message getStudents найден");
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("ageRe")
    public List<Student> findAgeStudent(@RequestParam int age1, @RequestParam int age2) {
        return studentService.findAgeStudent(age1, age2);
    }

    @PutMapping("update")
    public ResponseEntity<Student> updateStudents(@RequestBody Student student) {
        Student changeStudent = studentService.editStudent(student);
        if (changeStudent == null) {
            logger.debug("Info message updateStudents не получилось обновить ,что-то не так");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(changeStudent);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Student> deleteStudents(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("studentAge")
    public List<Student> studentAge(@RequestParam Integer age) {
        return studentService.getAge(age);
    }

    @GetMapping("allStudentCount")
    public ResponseEntity<Integer> allStudentCount() {
        int count1 = studentService.findStudentr();
        if (count1 == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(count1);
    }

    @GetMapping("getAverageAgeOfStudents")
    public ResponseEntity<Integer> getAverageAgeOfStudents() {
        int ageAverage = studentService.getAverageAge();
        if (ageAverage == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ageAverage);
    }

    @GetMapping("getLastStudents")
    public ResponseEntity<List<Student>> getLastStudents() {
        List<Student> lastStudents = studentService.getLastStudents();
        if (lastStudents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lastStudents);
    }
}