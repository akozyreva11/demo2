package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;


@RequestMapping("faculty")
@RestController
public class FacultyController {

        private final FacultyService facultyService;

        public FacultyController (FacultyService facultyService) {
            this.facultyService = facultyService;
        }

        @PostMapping
        public ResponseEntity<Faculty> createUser(@RequestBody Faculty faculty) {
            Faculty createdUser = facultyService.createFaculty(faculty);
            return ResponseEntity.ok(createdUser);
        }

        @GetMapping("{userId}")
        public ResponseEntity<Faculty> getUser(@PathVariable Long userId) {
            Faculty faculty = facultyService.getUserById(userId);
            if(faculty == null) {
                return ResponseEntity.notFound() .build();
            }
            return ResponseEntity.ok(faculty);
        }
}
