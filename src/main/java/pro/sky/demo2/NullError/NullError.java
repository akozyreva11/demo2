package pro.sky.demo2.NullError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class NullError extends IllegalArgumentException{

    public NullError() {
        super("Делить на 0 нельзя");
    }
}
