package pro.sky.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    @Autowired
    List<QuestionService> questionServices;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @Override
    public void getQuestions() {

    }

    @Override
    public Collection<QuestionService> getQuestions(int sum) {
        sum = javaQuestionService.getRandomQuestion();
        if (questionServices.size() > sum) {
            return questionServices;
        } else {
            throw new NullPointerException("Вывели всё что было");

        }
    }
}