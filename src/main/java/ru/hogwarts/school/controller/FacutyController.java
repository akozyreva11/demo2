package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacutyController {

    private FacultyService facultyService;

    public FacutyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("creater")
    public Faculty createFacultyes(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("id")
    public ResponseEntity<Faculty> getFacultyes(@PathVariable Long id) {
        Faculty newFaculty = facultyService.findFaculty(id);
        if (newFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newFaculty);
    }

    @PutMapping("id")
    public ResponseEntity<Faculty> updateFacultyes(@RequestBody Faculty faculty, @PathVariable Long id) {
        Faculty changeFaculty = facultyService.editFaculty(id, faculty);
        if (changeFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(changeFaculty);
    }

    @GetMapping ("name")
    public List <Faculty> findColorFaculty (@RequestParam String name)
    {
    return facultyService.findFacultyColor(name);
    }

    @GetMapping("getFacultyAll")
    public ResponseEntity<Collection<Student>> getFacultyesByStudents(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyService.findFaculty(id).getStudents());
    }

    @DeleteMapping("id")
    public ResponseEntity<Faculty> deleteFacultyes(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("coloradd")
    public List<Faculty> collorsOfFaculty(@RequestParam String collor) {
        return facultyService.facultyCollor(collor);
    }
}