package com.home.stadium.external.apiFootball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiFootballVenueDto {
    @JsonProperty("venue_name")
    private String name;

    @JsonProperty("venue_address")
    private String address;

    @JsonProperty("venue_city")
    private String city;

    @JsonProperty("venue_capacity")
    private String capacity;

    @JsonProperty("venue_surface")
    private String surface;
}
