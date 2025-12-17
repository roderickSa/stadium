package com.home.stadium.exceptions;

public class ZoneNotFoundException extends ExternalServiceException {
    public ZoneNotFoundException() {
        super("Zone not found", "ZONE-404");
    }
}
