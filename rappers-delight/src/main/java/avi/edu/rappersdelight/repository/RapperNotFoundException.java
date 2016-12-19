package avi.edu.rappersdelight.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class RapperNotFoundException extends RuntimeException {
    public RapperNotFoundException(String message) {
        super(message);
    }
}
