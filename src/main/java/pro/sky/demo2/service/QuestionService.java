package pro.sky.demo2.service;

import pro.sky.demo2.question.Question;

import java.util.Collection;

public interface QuestionService {

    Question addQuestion(Question question);

    Question add(String question, String answer);

    Question removeQuestion(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
