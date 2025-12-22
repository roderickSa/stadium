package com.home.stadium.exceptions;

public class UsernameAlreadyExistsException extends ExternalServiceException {
    public UsernameAlreadyExistsException() {
        super("Username already exists", "USERNAME-409");
    }
}
