package com.ecomApp.ecomApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> productNotFoundException(ProductNotFoundException ex){
        ErrorResponse err = new ErrorResponse().builder().
                message(ex.getMessage())
                .time(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND
                        .value()).build();


//
//        err.setStatus(HttpStatus.NOT_FOUND.value());
//        err.setMessage(ex.getMessage());
//        err.setTime(LocalDateTime.now());




        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> productNotFoundException(CategoryNotFoundException ex){
        ErrorResponse err = new ErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTime(LocalDateTime.now());




        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }






}
