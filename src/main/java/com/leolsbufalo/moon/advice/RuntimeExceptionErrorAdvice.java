package com.leolsbufalo.moon.advice;

import com.leolsbufalo.moon.model.ErrorObject;
import com.leolsbufalo.moon.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RuntimeExceptionErrorAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> processRuntimeException(RuntimeException ex) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = new ErrorResponse(
                "Internal server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getClass().getName(),
                errors);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse("Invalid fields", status.value(),
                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }

    private List<ErrorObject> getErrors(RuntimeException ex) {
        ErrorObject errorObject = new ErrorObject(ex.getMessage(), ex.getLocalizedMessage(), ex.getCause());
        ArrayList<ErrorObject>  list = new ArrayList<ErrorObject>();
        list.add(errorObject);
        return list;
    }
}
