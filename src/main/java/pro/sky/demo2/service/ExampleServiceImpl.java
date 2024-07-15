package pro.sky.demo2.service;

import Question.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class ExampleServiceImpl implements QuestionService {


    @Override
    public int getRandomQuestion() {

        return 0;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return List.of();
    }

    @Override
    public Question add(Question question) {
        return null;
    }
}
