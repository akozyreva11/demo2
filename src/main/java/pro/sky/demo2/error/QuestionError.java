package pro.sky.demo2.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuestionError extends RuntimeException {
    private static final String message = "Запрошено слишком много пар";

    public QuestionError() {
        super(message);

    }

}