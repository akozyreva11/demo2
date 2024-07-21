package pro.sky.demo2.service.impl.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.demo2.question.Question;
import pro.sky.demo2.service.impl.ExaminerServiceImpl;
import pro.sky.demo2.service.impl.JavaQuestionService;

import java.util.Collection;
import java.util.Set;

@ExtendWith(MockitoExtension.class)

public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;


    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Collection<Question> questions = Set.of(
            new Question("Алёна1", "Алёна?"),
            new Question("Алёна2", "Алёна?"),
            new Question("Алёна3", "Алёна?"),
            new Question("Алёна4", "Алёна?")
    );

@Test
void getQuestionTest() {
    Mockito.when(javaQuestionService.getAll()).thenReturn(questions);
    Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(
            new Question("Алёна1", "Алёна?"),
            new Question("Алёна2", "Алёна?"),
            new Question("Алёна3", "Алёна?"),
            new Question("Алёна4", "Алёна?")
    );
    Assertions.assertThat(examinerService.getQuestions(3))
            .hasSize(3)
            .containsExactlyInAnyOrder(
                    new Question("Алёна1", "Алёна?"),
                    new Question("Алёна2", "Алёна?"),
                    new Question("Алёна3", "Алёна?"));
}
}