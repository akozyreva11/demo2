package pro.sky.demo2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class EmployeeInvalidExeption extends RuntimeException {
    public EmployeeInvalidExeption() {
    }

    public EmployeeInvalidExeption(String message) {
        super(message);
    }

    public EmployeeInvalidExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeInvalidExeption(Throwable cause) {
        super(cause);
    }

    public EmployeeInvalidExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
