package ru.tt.Sprinlistandmap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ACCEPTED)
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
