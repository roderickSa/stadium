package com.home.stadium.exceptions;

public class StadiumNotFoundException extends ExternalServiceException {
    public StadiumNotFoundException() {
        super("Stadium not found", "STADIUM-404");
    }
}
