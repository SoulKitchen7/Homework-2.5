package pro.sky.java.course2.homework25.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

}
