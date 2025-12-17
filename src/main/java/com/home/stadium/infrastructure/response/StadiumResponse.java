package com.home.stadium.infrastructure.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class StadiumResponse {
    private String id;
    private String name;
    private String description;
    private List<ZoneResponse> zones;
}
