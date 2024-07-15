package pro.sky.demo2.service;

import Question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();
    int number;

    @Override
    public int getRandomQuestion() {

        Random random = new Random();
        number = random.nextInt(10);
        return 0;
    }


    @Override
    public Question add(Question question) {
        if (questions.size() < 9) {
            questions.add(question);
        } else {
            throw new NullPointerException("Такое значение уже существует");
        }
        return question;
    }

    //Удалить сотрудника.
    @Override
    public Question remove(Question question) throws NullPointerException {
        if (questions.contains(question)) {
            questions.remove(question);
        } else {
            throw new NullPointerException("Такого значения не существует");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return (Collections.unmodifiableCollection(questions));
    }
}