package com.inpowered.candidate.levy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "permission.not-exist.error")
public class PermissionNotExistException extends RuntimeException {
}
