package pro.sky.demo2.service;

import pro.sky.demo2.question.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
