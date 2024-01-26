package com.rest.webservices.restfulwebservices.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class UserExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundExceptions(UserNotFoundException e) {
        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        e.getMessage(),
                        "Contact the database team for clarification"
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handlePostNotFoundExceptions(PostNotFoundException e) {
        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        e.getMessage(),
                        "Try with a valid post id"
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        LOGGER.error(String.valueOf(e));
        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        e.getFieldError().getDefaultMessage(),
                        "Check the request body and send a valid input"
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllOtherExceptions(Exception e) {
        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        "An Error Occurred",
                        "Contact Administrator"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
