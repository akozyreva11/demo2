package pro.sky.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.question.Question;
import pro.sky.demo2.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/alls")
public class ExamController {


    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    //localhost:8080/exam/get?question=%22%D0%9A%D1%82%D0%BE%20%D0%BF%D1%80%D0%BE%D0%B6%D0%B8%D0%B2%D0%B0%D0%B5%D1%82%20%D0%BD%D0%B0%20%D0%B4%D0%BD%D0%B5%20%D0%BE%D0%BA%D0%B5%D0%B0%D0%BD%D0%B0?%22&answer=%22%D0%A1%D0%BF%D0%B0%D0%BD%D1%87%D0%B1%D0%BE%D0%B1%22

    @GetMapping(path = "/exam/get")
    public Collection<Question> getRandomio(
            @RequestParam int amount) {

        return examinerService.getQuestions(amount);
    }

}
