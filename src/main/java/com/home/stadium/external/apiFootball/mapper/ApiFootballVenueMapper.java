package com.home.stadium.external.apiFootball.mapper;

import java.util.List;

import com.home.stadium.domain.model.Venue;
import com.home.stadium.external.apiFootball.dto.ApiFootballVenueDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiFootballVenueMapper {
    public static Venue toResponse(ApiFootballVenueDto venue) {
        if (venue == null) {
            return null;
        }

        return Venue.builder()
                .name(venue.getName())
                .address(venue.getAddress())
                .city(venue.getCity())
                .capacity(venue.getCapacity())
                .surface(venue.getSurface())
                .build();
    }

    public static List<Venue> toResponseList(List<ApiFootballVenueDto> venues) {
        return venues.stream()
                .map(ApiFootballVenueMapper::toResponse)
                .toList();
    }
}
