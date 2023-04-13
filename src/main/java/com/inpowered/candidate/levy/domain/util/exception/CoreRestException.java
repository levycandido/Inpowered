package com.inpowered.candidate.levy.domain.util.exception;

/**
 * Throwable Rest Exception to generate custom exception for Rest APIs. We can keep a standard exception format
 * for all kind of exceptions.
 *
 * @author wahab.ahmed
 * @version 1.0
 */
public class CoreRestException extends Throwable {
    /***
     * Should throw an Exception by message only
     *
     * @param message
     */
    public CoreRestException(String message) {
        super(message);
    }

    /***
     * Should trow an Exception by message and cause of the Exception
     *
     * @param message Define message that what happened according to the Exception
     * @param cause The Real Exception that needs to be thrown
     */
    public CoreRestException(String message, Throwable cause) {
        super(message, cause);
    }
}
