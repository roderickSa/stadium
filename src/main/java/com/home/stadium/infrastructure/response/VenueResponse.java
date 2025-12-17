package com.home.stadium.infrastructure.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class VenueResponse {
    private String name;
    private String address;
    private String city;
    private String capacity;
    private String surface;
}
