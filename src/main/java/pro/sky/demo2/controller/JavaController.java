package pro.sky.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.question.Question;
import pro.sky.demo2.service.impl.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class JavaController {
    private final JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")

    //localhost:8080/exam/add?question=22&answer=22
    //localhost:8080/exam/add?question=SSSSSSSSSSSSSSSSSSSs&answer=SSssssssz
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        Question questions = new Question(
                question,
                answer
        );
        return javaQuestionService.addQuestion(questions);

    }

    @GetMapping(path = "/remove")


    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        Question questions = new Question(
                question,
                answer
        );
        return javaQuestionService.removeQuestion(questions);
    }

    @GetMapping("/all")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}
