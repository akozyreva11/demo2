package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController


public class StudentController {
    private final StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }
    @RequestMapping (value = "/exam/creater", method = RequestMethod.POST)

    public ResponseEntity<Student> createUser(@RequestBody Student student) {
        Student createdUser = studentService.createUser(student);
        return ResponseEntity.ok(createdUser);
    }


    @DeleteMapping (path = "/exam/delete")
    public ResponseEntity<Student> deleteUser(@RequestBody  Long userId) {
        Student deleteUser = studentService.deleteUser(userId);
        return ResponseEntity.ok(deleteUser);
    }


    @PutMapping (path = "/exam/update")
    public ResponseEntity<Student> updateUser(@RequestBody Student student) {
        Student  updateUser = studentService.updateUser(student.getId(), student);
        return ResponseEntity.ok(updateUser);
    }

    @GetMapping(path = "/exam/filter")
    public Collection<Student>  getfilter(@RequestParam int age) {
        return  studentService.ageSortUser(age);
    }
}
