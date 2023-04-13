package com.inpowered.candidate.levy.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class JsonValidationExceptionHandler {

    @ExceptionHandler(JsonValidationFailedException.class)
    public ResponseEntity<Map<String, Object>> onJsonValidationFailedException(JsonValidationFailedException ex) {
        return null;
    }
}
