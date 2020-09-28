package com.leolsbufalo.moon.advice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.leolsbufalo.moon.model.ErrorObject;
import com.leolsbufalo.moon.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
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
        JsonMappingException jsonMappingException = (JsonMappingException) exception.getCause();
        List<ErrorObject> errors = getErrors(exception, jsonMappingException);
        ErrorResponse errorResponse = getErrorResponse(exception, HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse getErrorResponse(HttpMessageNotReadableException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse("Invalid type on properties", status.value(),
                status.getReasonPhrase(), ex.getClass().getSimpleName(), errors);
    }

    private List<ErrorObject> getErrors(HttpMessageNotReadableException exception, JsonMappingException jsonMappingException) {
        return List.of( new ErrorObject(
                "Parse Error, wrong type sent",
                jsonMappingException.getPath().get(0).getFieldName()));
    }
}
