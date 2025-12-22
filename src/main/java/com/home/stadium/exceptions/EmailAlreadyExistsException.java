package com.home.stadium.exceptions;

public class EmailAlreadyExistsException extends ExternalServiceException {
    public EmailAlreadyExistsException() {
        super("Email already exists", "EMAIL-409");
    }
}
