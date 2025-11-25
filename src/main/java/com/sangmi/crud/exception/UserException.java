package com.sangmi.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError>handleGenericException(Exception ex){
        CustomError error = new CustomError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle specific exceptions (e.g., User not found)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomError> handleUserNotFound(UserNotFoundException ex) {
        CustomError error = new CustomError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
