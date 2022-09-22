package ru.tt.Sprinlistandmap.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED)
public class EmployeeAlreadyAddException extends RuntimeException{
    public EmployeeAlreadyAddException(String message) {
        super(message);
    }
}
