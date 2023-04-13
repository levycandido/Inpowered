package com.inpowered.candidate.levy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "costumer.not-exist.error")
public class CostumerNotExistException extends RuntimeException {
}
