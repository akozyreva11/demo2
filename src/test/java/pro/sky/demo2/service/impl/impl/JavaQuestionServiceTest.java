package pro.sky.demo2.service.impl.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.demo2.error.QuestionDoesNotError;
import pro.sky.demo2.error.QuestionError;
import pro.sky.demo2.question.Question;
import pro.sky.demo2.service.impl.JavaQuestionService;


class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionServicetest = new JavaQuestionService();

    @Test
    void checkAdd() {
        javaQuestionServicetest.add("Оля?", "НЕт, Толя");

        Assertions.assertThat(javaQuestionServicetest.getAll())
                .contains(new Question("Оля?", "НЕт, Толя"));
    }

    @Test
    void checkAddQuestion() {
        Question question = new Question("Оля1?", "НЕт, Толя1");
        Question question2 = new Question("Оля2?", "НЕт, Толя2");
        javaQuestionServicetest.addQuestion(question);
        javaQuestionServicetest.addQuestion(question2);

        Assertions.assertThat(javaQuestionServicetest.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Оля1?", "НЕт, Толя1"),
                        new Question("Оля2?", "НЕт, Толя2"));
    }

    @Test
    void checkRemove() {
        Question question = new Question("Оля1?", "НЕт, Толя1");
        Question question2 = new Question("Оля2?", "НЕт, Толя2");
        Assertions.assertThat(javaQuestionServicetest.removeQuestion(question2))
                .isEqualTo(question2);
        Assertions.assertThat(javaQuestionServicetest.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Оля1?", "НЕт, Толя1"));
        Assertions.assertThatExceptionOfType(QuestionDoesNotError.class)
                .isThrownBy(() -> javaQuestionServicetest.removeQuestion(new Question("Оля22?", "НЕт, Толя22")));
    }

    @Test
    void checkGetAll() {
        Question question = new Question("Ваня 1", "Ваня 1?");
        Question question1 = new Question("Саня 2", "Саня 2?");
        Question question2 = new Question("Ира 3", "Ира 3?");

        Assertions.assertThat(javaQuestionServicetest.getAll()).containsExactlyInAnyOrder(question, question1, question2);
    }


    @Test
    void checkGetRandomQuestionError() {
        for (int i = 0; i < 10; i++) {
            Assertions.assertThatExceptionOfType(QuestionError.class);
        }
    }

    @Test
    void checkGetRandomQuestion() {
        Question question = new Question("Оля1?", "НЕт, Толя1");
        Question question2 = new Question("Оля2?", "НЕт, Толя2");
        javaQuestionServicetest.addQuestion(question);
        javaQuestionServicetest.addQuestion(question2);
        for (int i = 0; i < 2; i++) {
                Assertions.assertThat(javaQuestionServicetest.getAll())
                        .contains(javaQuestionServicetest.getRandomQuestion());
            }
    }
}
