package com.leolsbufalo.moon.advice;

import com.leolsbufalo.moon.model.Error;
import com.leolsbufalo.moon.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ArgumentNotValidErrorAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ResponseEntity ArgumentNotValidErrorAdviceHandle(MethodArgumentNotValidException exception) {
        List<Error> errors = getErrors(exception);
        ErrorResponse errorResponse = getErrorResponse(exception, HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    private ErrorResponse getErrorResponse(MethodArgumentNotValidException exception, HttpStatus status, List<Error> errors) {
        return new ErrorResponse("Invalid fields", status.value(),
                status.getReasonPhrase(), exception.getBindingResult().getObjectName(), errors);
    }

    private List<Error> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new Error(error.getDefaultMessage(), error.getField()))
                .collect(Collectors.toList());
    }
}
