package pro.sky.demo2.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class QuestionDoesNotError extends RuntimeException {
    public QuestionDoesNotError() {
        super();
    }

    public QuestionDoesNotError(String message) {
        super(message);
    }
}