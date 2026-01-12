package org.example.backendtickingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EmployeeLoginException extends RuntimeException {
    public EmployeeLoginException() {
        super("Invalid username or password");
    }

    public EmployeeLoginException(String message) {
        super(message);
    }

    public EmployeeLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}