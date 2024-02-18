package com.emailserviceuber.core.exceptions;

public class EmailServiceException extends RuntimeException{

    public EmailServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailServiceException(String message) {
        super(message);
    }
}
