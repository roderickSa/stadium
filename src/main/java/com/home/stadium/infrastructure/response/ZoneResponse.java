package com.home.stadium.infrastructure.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class ZoneResponse {
    private String id;
    private String stadiumId;
    private String name;
    private int capacity;
    private String status;
    private String description;
}
