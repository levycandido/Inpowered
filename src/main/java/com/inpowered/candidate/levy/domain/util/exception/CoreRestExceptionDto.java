package com.inpowered.candidate.levy.domain.util.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * Custom Dto for Exceptions to use only one standard for all kind of Exceptions
 *
 * @author wahab.ahmed
 * @version 1.0
 */
public class CoreRestExceptionDto {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public CoreRestExceptionDto(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
