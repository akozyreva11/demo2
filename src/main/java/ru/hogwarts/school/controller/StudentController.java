package ru.hogwarts.school.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student addedStudent = studentService.createStudent(student);
        return ResponseEntity.ok(addedStudent);
    }

    @GetMapping("AllStudent")
    public ResponseEntity<Student> allStudent(@PathVariable Long id) {
        Student newStudent = studentService.findStudent(id);
        if (newStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("id")
    public ResponseEntity<Student> getStudents(@PathVariable Long id) {
        Student newStudent = studentService.findStudent(id);
        if (newStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("ageRe")
    public List <Student> findAgeStudent (@RequestParam int age1, @RequestParam int age2) {
        return studentService.findAgeStudent(age1, age2);
   }

    @PutMapping("id")
    public ResponseEntity<Student> updateStudents(@RequestBody Student student, @PathVariable Long id) {
        Student changeStudent = studentService.editStudent(id, student);
        if (changeStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(changeStudent);
    }

    @DeleteMapping("id")
    public ResponseEntity<Student> deleteStudents(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Student> studentAge(@PathVariable Integer age) {
        return studentService.getAge(age);
    }
}