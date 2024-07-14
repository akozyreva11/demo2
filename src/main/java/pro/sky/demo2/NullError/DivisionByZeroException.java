package pro.sky.demo2.NullError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class DivisionByZeroException extends IllegalArgumentException{

    public DivisionByZeroException() {
        super("Division by zero is not allowed");
    }
}
