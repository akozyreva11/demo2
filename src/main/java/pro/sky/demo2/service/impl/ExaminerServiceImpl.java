package pro.sky.demo2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.demo2.error.QuestionErrorNotAll;
import pro.sky.demo2.question.Question;
import pro.sky.demo2.service.ExaminerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestion;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, JavaQuestionService javaQuestion) {
        this.javaQuestion = javaQuestion;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > javaQuestion.getAll().size()) {
            throw new QuestionErrorNotAll("В списке нет столько вопросов");
        }
        Set<Question> question = new HashSet<>();
        while (question.size() < amount) {
            question.add(javaQuestion.getRandomQuestion());
        }

        return question;
    }
}
