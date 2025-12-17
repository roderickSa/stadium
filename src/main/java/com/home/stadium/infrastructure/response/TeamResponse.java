package com.home.stadium.infrastructure.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class TeamResponse {
    private String key;
    private String name;
    private String country;
    private String founded;
    private String badgeUrl;
    private VenueResponse venue;
}
