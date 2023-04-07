package com.example.employee_management_azure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<MyErrorDetails> EmployeeExceptionHandler(EmployeeException exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MyErrorDetails> IllegalArgumentExceptionHandler(IllegalArgumentException exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MyErrorDetails> HotelExceptionHandler(RuntimeException exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
