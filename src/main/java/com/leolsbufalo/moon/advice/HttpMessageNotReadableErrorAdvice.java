package com.leolsbufalo.moon.advice;

import com.leolsbufalo.moon.model.ErrorObject;
import com.leolsbufalo.moon.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class HttpMessageNotReadableErrorAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorResponse(HttpMessageNotReadableException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse("Invalid fields", status.value(),
                status.getReasonPhrase(), ex.getClass().getName(), errors);
    }

    private List<ErrorObject> getErrors(HttpMessageNotReadableException ex) {
        return (List<ErrorObject>) Arrays.stream(ex.getClass().getDeclaredFields())
                .map(error -> new ErrorObject("Error test", "field.error", "test"));
    }
}
