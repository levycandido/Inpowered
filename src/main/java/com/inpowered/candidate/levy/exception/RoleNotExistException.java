package com.inpowered.candidate.levy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "role.not-exist.error")
public class RoleNotExistException extends RuntimeException {
}
