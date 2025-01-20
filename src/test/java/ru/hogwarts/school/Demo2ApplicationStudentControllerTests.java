package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.controller.AvatarController;
import ru.hogwarts.school.controller.FacutyController;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;

//Данная аннотация нужна для того чтобы спринг нашел далее аннотацию SpringBootApplication и начнёт искать в пакете бин и сервисы
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo2ApplicationStudentControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;
    @Autowired
    private AvatarController avatarController;
    @Autowired
    private FacutyController facutyController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void testAllStudent() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/AllStudent", String.class)).isNotNull();
    }

    @Test
    public void testGetAgeRe() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/ageRe?age1=22&age2=33", String.class))
                .contains("stridddd   dddddng");
    }

    @Test
    public void testPostCreateStudent() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(23);
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/addStudent", student, String.class)).contains("Bob");
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setName("Bobi");
        student.setAge(33);
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student/update?id=12", student, String.class)).isNotNull();
    }
}
