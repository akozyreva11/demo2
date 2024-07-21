package pro.sky.demo2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.demo2.error.QuestionDoesNotError;
import pro.sky.demo2.error.QuestionError;
import pro.sky.demo2.question.Question;
import pro.sky.demo2.service.QuestionService;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService() {
        questions = new HashSet<>();
    }


    @Override
    public Question addQuestion(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    public Question removeQuestion(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionDoesNotError("Такого вопроса нет в списке");
        }
        questions.remove(question);
        return question;
    }



    @Override
    public Collection<Question> getAll() {
        return (Collections.unmodifiableCollection(questions));
    }


    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (questions.isEmpty()) {
            throw new QuestionError();
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}