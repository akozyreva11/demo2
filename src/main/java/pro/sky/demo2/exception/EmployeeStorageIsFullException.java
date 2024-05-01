package pro.sky.demo2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends  RuntimeException{
    private static final String message="Такая уже есть";

    public EmployeeStorageIsFullException(){
        super(message);
        
    }

}
