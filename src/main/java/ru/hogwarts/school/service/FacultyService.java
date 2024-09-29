package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Value("${student-forecast-service.url}")
    private String url;

    @Value("${student-forecast-service.api-key}")
    private String apiKey;
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Info message createFaculty");
    return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("Info message findById");
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> findFacultyColor(String name) {
        logger.info("Info message findFacultyColor");
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Info message editFaculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("Info message deleteById");
        facultyRepository.deleteById(id);
    }

    public List<Faculty> facultyCollor(String collor) {
        logger.info("Info message facultyCollor");
        return facultyRepository.findAll().stream().
                filter(faculty -> faculty.getColor() == collor).
                collect(Collectors.toList());

    }

}