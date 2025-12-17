package com.home.stadium.infrastructure.mapper;

import java.util.List;

import com.home.stadium.domain.model.Venue;
import com.home.stadium.infrastructure.response.VenueResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VenueMapper {
    public static VenueResponse toResponse(Venue venue) {
        if (venue == null) {
            return null;
        }

        return VenueResponse.builder()
                .name(venue.getName())
                .address(venue.getAddress())
                .city(venue.getCity())
                .capacity(venue.getCapacity())
                .surface(venue.getSurface())
                .build();
    }

    public static List<VenueResponse> toResponseList(List<Venue> venues) {
        return venues.stream()
                .map(VenueMapper::toResponse)
                .toList();
    }
}
