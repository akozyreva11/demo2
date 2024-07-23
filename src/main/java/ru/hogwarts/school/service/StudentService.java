package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class StudentService {

    private Map<Long, Student> students = new HashMap<>();
    public Long Id=1L;
    Student student1=new Student(4444L,"вввввввв",33);
    Student student2=new Student(444L,"вввввввв",34);
    Student student3=new Student(444L,"вввввsввв",34);


    public Student createUser(Student student) {
        students.put(Id, student);
        Id=Id++;
        return student;
    }
    public Collection<Student> ageSortUser(int age) {
        Collection<Student> studenta = students.values();
        return  studenta.
              stream().
              filter(e ->e.getAge()==age).
              collect(Collectors.toList());
    }


    public Student getUserById(Long Id) {
        return students.get(Id);
    }

    public Student updateUser(Long Id, Student student) {
        students.put(Id, student);
        return student;
    }

    public Student deleteUser(Long userId) {
        return students.remove(Id);
    }




}
