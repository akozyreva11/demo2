package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.controller.FacutyController;
import ru.hogwarts.school.model.Faculty;

//Данная аннотация нужна для того чтобы спринг нашел далее аннотацию SpringBootApplication и начнёт искать в пакете бин и сервисы
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo2ApplicationFacultyControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private FacutyController facutyController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(facutyController).isNotNull();
    }

    @Test
    public void testcreateFacultyes() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Bob");
        faculty.setColor("красный");
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty/creater", faculty, String.class)).contains("красный");
    }

    @Test
    public void testfindIdFacultyes() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty/findId?id=5", String.class))
                .contains("Факультет");
    }

    @Test
    public void testPostUpdateFacultyes() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("Sovok");
        faculty.setColor("ne o4en");
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty/updateFacultyes", faculty, String.class)).contains("Sovok");
    }

    @Test
    public void testfindColorFaculty() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty/findColorFaculty?name=Sovok", String.class)).isNotNull();
    }

    @Test
    public void testGetFacultyesByStudentsFaculty() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty/findColorFaculty?name=Sovok", String.class)).isNotNull();

    }

    @Test
    public void testDeleteFacultyes() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty/findColorFaculty?name=Sovok", String.class)).isNotNull();

    }
}
