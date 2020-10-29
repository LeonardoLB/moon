package com.leolsbufalo.moon.advice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.leolsbufalo.moon.model.Error;
import com.leolsbufalo.moon.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
public class HttpMessageNotReadableExceptionErrorAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ResponseEntity httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException exception) {
        List<Error> errors = getErrors(exception);
        ErrorResponse errorResponse = getErrorResponse(exception, HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse getErrorResponse(HttpMessageNotReadableException ex, HttpStatus status, List<Error> errors) {
        return new ErrorResponse("Invalid type on properties", status.value(),
                status.getReasonPhrase(), ex.getClass().getSimpleName(), errors);
    }

    private List<Error> getErrors(HttpMessageNotReadableException exception) {
        try {
            JsonMappingException jsonMappingException = (JsonMappingException) exception.getCause();
            return List.of(new Error("Parse Error, wrong type sent",
                    jsonMappingException.getPath().get(0).getFieldName()));
        } catch (Exception ex) {
            JsonParseException jsonParseException = (JsonParseException) exception.getCause();
            return List.of(new Error("Parse Error, wrong type sent, verify field description",
                    jsonParseException.getMessage() ));
        }
    }
}
