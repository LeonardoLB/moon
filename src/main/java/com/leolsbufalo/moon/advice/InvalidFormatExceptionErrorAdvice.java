package com.leolsbufalo.moon.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidFormatException {
    
    @ExceptionHandler(InvalidFormatException.class)
    protected ResponseEntity InvalidFormatExceptionHandler() {

    }
}
