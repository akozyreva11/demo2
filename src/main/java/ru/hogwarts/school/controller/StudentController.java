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

    @PostMapping("addStudent")
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

    @GetMapping("find")
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

    @PutMapping("update")
    public ResponseEntity<Student> updateStudents( @RequestBody Student student) {
        Student changeStudent = studentService.editStudent(student);
        if (changeStudent == null) {
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
    public List<Student> studentAge(@PathVariable Integer age) {
        return studentService.getAge(age);
    }
}