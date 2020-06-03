package lt.codeacademy.Blogas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BlogEntryNotFoundException extends RuntimeException {
    public BlogEntryNotFoundException(String message) {
        super(message);
    }
}
