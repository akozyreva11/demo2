package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service

public class FacultyService {

    private Map<Long, Faculty> facultys = new HashMap<>();
    public long Id=1L;

    Faculty facultq=new Faculty(1L,"фыв","вуу");
    Faculty facultq2=new Faculty(2L,"фыв","ввуу");
    Faculty facultq3=new Faculty(3L,"фыв","ввуу");

    public Faculty createFaculty(Faculty faculty) {
        facultys.put(Id, faculty);
        Id=Id++;
        return faculty;
    }

    public Faculty getUserById(Long Id) {
        return facultys.get(Id);
    }

    public Faculty removeFaculty(Long Id, Faculty faculty) {
        facultys.remove(Id, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long userId) {
        return facultys.remove(Id);
    }

}