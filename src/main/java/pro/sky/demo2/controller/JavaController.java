package pro.sky.demo2.controller;

import Question.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class JavaController {
    private final JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")

    //localhost:8080/exam/add?question=%22%D0%9A%D1%82%D0%BE%20%D0%BF%D1%80%D0%BE%D0%B6%D0%B8%D0%B2%D0%B0%D0%B5%D1%82%20%D0%BD%D0%B0%20%D0%B4%D0%BD%D0%B5%20%D0%BE%D0%BA%D0%B5%D0%B0%D0%BD%D0%B0?%22&answer=%22%D0%A1%D0%BF%D0%B0%D0%BD%D1%87%D0%B1%D0%BE%D0%B1%22

    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        Question questions = new Question(
                question,
                answer
        );
        return javaQuestionService.add(questions);


    }

    @GetMapping(path = "/remove")


    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        Question questions = new Question(
                question,
                answer
        );

        return javaQuestionService.remove(questions);

    }

    @GetMapping("/all")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}
