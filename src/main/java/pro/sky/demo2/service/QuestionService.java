package pro.sky.demo2.service;

import Question.Question;

import java.util.Collection;

public interface QuestionService {

    int getRandomQuestion();

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
