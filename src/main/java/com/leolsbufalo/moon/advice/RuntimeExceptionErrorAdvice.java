package com.leolsbufalo.moon.advice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.leolsbufalo.moon.model.ErrorObject;
import com.leolsbufalo.moon.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class RuntimeExceptionErrorAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected ResponseEntity JsonProcessingExceptionHandler(RuntimeException exception) {
        List<ErrorObject> errors = getErrors(exception);
        ErrorResponse errorResponse = getErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse getErrorResponse(RuntimeException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse("Error to parse value", status.value(),
                status.getReasonPhrase(), ex.getClass().getSimpleName(), errors);
    }

    private List<ErrorObject> getErrors(RuntimeException exception) {
        try {
            JsonMappingException jsonMappingException = (JsonMappingException) exception.getCause();
            return List.of(new ErrorObject("Mapper Error",
                    jsonMappingException.getPath().get(0).getFieldName()));
        } catch (Exception ex) {
            JsonParseException jsonParseException = (JsonParseException) exception.getCause();
            return List.of(new ErrorObject("Error to execute JsonMapper",
                    jsonParseException.getLocation().toString() ));
        }
    }
}
