package com.inpowered.candidate.levy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "costumer.not-authorized.error")
public class AuthenticationException extends RuntimeException {
}
