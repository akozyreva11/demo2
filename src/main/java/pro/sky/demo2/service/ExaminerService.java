package pro.sky.demo2.service;

import java.util.Collection;

public interface ExaminerService {
    void getQuestions();

    Collection<QuestionService> getQuestions(int sum);
}
