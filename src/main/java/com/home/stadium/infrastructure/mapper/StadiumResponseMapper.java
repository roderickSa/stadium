package com.home.stadium.infrastructure.mapper;

import java.util.List;

import com.home.stadium.domain.model.Stadium;
import com.home.stadium.infrastructure.response.StadiumResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StadiumResponseMapper {
    public static StadiumResponse toResponse(Stadium stadium) {
        if (stadium == null) {
            return null;
        }

        return StadiumResponse.builder()
                .id(stadium.getId().toString())
                .name(stadium.getName())
                .description(stadium.getDescription())
                .zones(ZoneResponseMapper.toResponseList(stadium.getZones()))
                .build();
    }

    public static List<StadiumResponse> toResponseList(List<Stadium> stadiums) {
        return stadiums.stream()
                .map(StadiumResponseMapper::toResponse)
                .toList();
    }
}
