package com.inpowered.candidate.levy.domain.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

/**
 * This Should Generate a CoreRestException according to the Core Exception
 *
 * @author wahab.ahmed
 * @version 1.0
 */
@ControllerAdvice
public class CoreRestExceptionHandler {

    @ExceptionHandler(value = {CoreRestException.class})
    public ResponseEntity<Object> handleCoreRestException(CoreRestException restException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        CoreRestExceptionDto exception = new CoreRestExceptionDto(
            restException.getMessage(),
            restException,
            status,
            ZonedDateTime.now()
        );

        return new ResponseEntity<>(exception, status);
    }
}
