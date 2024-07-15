package pro.sky.demo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.service.JavaQuestionService;

@RestController
@RequestMapping(path = "/alls")
public class ExamController {

    private final JavaQuestionService javaQuestionService;

    public ExamController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    public int addQuestion(int sum) {
        return javaQuestionService.getRandomQuestion();


    }
}
