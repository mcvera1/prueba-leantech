package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee not found")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String exception) {
        super(exception);
    }
}
