package com.inpowered.candidate.levy.domain.util.exception;

import java.text.MessageFormat;

/**
 * This should help us to keep messages consistency on all platforms, so define all messages format her. It will be very useful at backend and frontend.
 * We can change these to friendly messages at any time.
 *
 * @author wahab.ahmed
 * @version 1.0
 */
public class CoreExceptionMessages {
    public static final String OBJECT_ALREADY_EXISTS = "{0}({1}) Already Exists";
    public static final String OBJECT_NOT_FOUND = "{0} object has not been found by id {1}";
    public static final String FILE_NOT_FOUND = "Requested File has not been found {0}";

    public static String objectNotFound(String name, String id) {
        return (MessageFormat.format(OBJECT_NOT_FOUND, name, id));
    }

    public static String fileNotFound(String filePath) {
        return (MessageFormat.format(FILE_NOT_FOUND, filePath));
    }

    public static String objectAlreadyExists(String name, String id) {
        return (MessageFormat.format(OBJECT_ALREADY_EXISTS, name, id));
    }
}
