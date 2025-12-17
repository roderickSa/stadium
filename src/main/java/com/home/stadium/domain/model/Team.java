package com.home.stadium.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class Team {
    private String key;
    private String name;
    private String country;
    private String founded;
    private String badgeUrl;
    private Venue venue;
}
