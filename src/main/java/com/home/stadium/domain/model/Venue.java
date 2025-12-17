package com.home.stadium.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class Venue {
    private String name;
    private String address;
    private String city;
    private String capacity;
    private String surface;
}
