package ru.hogwarts.school;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hogwarts.school.service.StudentService;

@SpringBootTest
class Demo2ApplicationTests {
	private final StudentService studentService;

    Demo2ApplicationTests(StudentService studentService) {
        this.studentService = studentService;
    }


    @Test
	void contextLoads() {

	}

}
