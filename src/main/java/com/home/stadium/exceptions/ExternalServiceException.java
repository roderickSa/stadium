package com.home.stadium.exceptions;

public class ExternalServiceException extends RuntimeException {
    private final String errorCode;

    protected ExternalServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
