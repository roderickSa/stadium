package com.home.stadium.exceptions;

public class ApiFootballServerException extends ExternalServiceException {
    public ApiFootballServerException() {
        super("ApiFootball server error", "AF-500");
    }
}
