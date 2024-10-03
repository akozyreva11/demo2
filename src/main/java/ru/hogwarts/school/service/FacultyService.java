package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service


public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> findFacultyColor(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> facultyCollor(String collor) {
        return facultyRepository.findAll().stream().
                filter(faculty -> faculty.getColor() == collor).
                collect(Collectors.toList());

    }

    public Optional<String> getBigNameOfFaculty() {
        List<Faculty> faculties = facultyRepository.findAll();

        return faculties.stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length));
    }
}