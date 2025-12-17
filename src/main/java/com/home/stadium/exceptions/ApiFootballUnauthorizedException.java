package com.home.stadium.exceptions;

public class ApiFootballUnauthorizedException extends ExternalServiceException {
    public ApiFootballUnauthorizedException() {
        super("Invalid or missing API key for ApiFootball", "AF-401");
    }
}
