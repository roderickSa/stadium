package com.home.stadium.external.apiFootball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiFootballTeamDto {
    @JsonProperty("team_key")
    private String key;

    @JsonProperty("team_name")
    private String name;

    @JsonProperty("team_country")
    private String country;

    @JsonProperty("team_founded")
    private String founded;

    @JsonProperty("team_badge")
    private String badgeUrl;

    @JsonProperty("venue")
    private ApiFootballVenueDto venue;
}
