package com.home.stadium.infrastructure.mapper;

import java.util.List;

import com.home.stadium.domain.model.Zone;
import com.home.stadium.infrastructure.response.ZoneResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ZoneResponseMapper {
    public static ZoneResponse toResponse(Zone zone) {
        if (zone == null) {
            return null;
        }

        return ZoneResponse.builder()
                .id(zone.getId().toString())
                .name(zone.getName())
                .capacity(zone.getCapacity())
                .status(zone.getStatus().name())
                .build();
    }

    public static List<ZoneResponse> toResponseList(List<Zone> zones) {
        if (zones == null) {
            return null;
        }

        return zones.stream()
                .map(ZoneResponseMapper::toResponse)
                .toList();
    }
}
