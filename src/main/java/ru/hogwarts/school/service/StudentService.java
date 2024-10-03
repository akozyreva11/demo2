package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;
    private Integer count = 1;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAgeStudent(int age1, int age2) {
        return studentRepository.findByAgeBetween(age1, age2);
    }

    public int getAverageAge() {
        return studentRepository.averageAge();
    }

    public List<Student> getLastStudents() {
        return studentRepository.getLastStudents();
    }

    public int findStudentr() {
        return studentRepository.getAllByStudent();
    }

    public Student findStudent(Long id) {
        return studentRepository.getById(id);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAge(Integer age) {
        return studentRepository.findAll().stream().
                filter(student -> student.getAge() == age).
                collect(Collectors.toList());
    }


    public void printParallel() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students.get(0).getName());
        System.out.println(students.get(1).getName());

        new Thread(() -> {
            System.out.println(students.get(2).getName());
            System.out.println(students.get(3).getName());
        }).start();

        new Thread(() -> {
            System.out.println(students.get(4).getName());
            System.out.println(students.get(5).getName());
        }).start();

    }


    public void printSynchronized() {
        List<Student> students = studentRepository.findAll();

        printStudName(students);
        printStudName(students);

        new Thread(() -> {
            printStudName(students);
            printStudName(students);
        }).start();

        new Thread(() -> {
            printStudName(students);
            printStudName(students);
        }).start();
    }

    private synchronized void printStudName(List<Student> students) {
        System.out.println(count + students.get(count).getName());
        count++;
    }
}
