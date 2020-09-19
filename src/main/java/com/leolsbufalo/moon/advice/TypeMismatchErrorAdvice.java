package com.leolsbufalo.moon.advice;

import com.leolsbufalo.moon.model.ErrorObject;
import com.leolsbufalo.moon.model.ErrorResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TypeMismatchErrorAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorResponse(TypeMismatchException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse("Invalid fields", status.value(),
                status.getReasonPhrase(), ex.getClass().getName(), errors);
    }

    private List<ErrorObject> getErrors(RuntimeException ex) {
        ErrorObject errorObject = new ErrorObject(ex.getMessage(), ex.getLocalizedMessage(), ex.getCause());
        ArrayList<ErrorObject> list = new ArrayList<ErrorObject>();
        list.add(errorObject);
        return list;
    }
}
