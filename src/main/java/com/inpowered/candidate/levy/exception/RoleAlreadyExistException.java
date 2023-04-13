package com.inpowered.candidate.levy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "role.already-exist.error")
public class RoleAlreadyExistException extends RuntimeException {
}
