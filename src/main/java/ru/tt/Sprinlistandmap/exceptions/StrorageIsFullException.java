package ru.tt.Sprinlistandmap.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class StrorageIsFullException extends RuntimeException{
    public StrorageIsFullException(String message) {
        super(message);
    }
}
