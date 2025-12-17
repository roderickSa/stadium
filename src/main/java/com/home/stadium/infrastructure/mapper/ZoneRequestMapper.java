package com.home.stadium.infrastructure.mapper;

import com.home.stadium.domain.model.Zone;
import com.home.stadium.infrastructure.request.ZoneRequest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ZoneRequestMapper {
    public static Zone toResponse(ZoneRequest zoneRequest) {
        return Zone.builder()
                .name(zoneRequest.getName())
                .capacity(zoneRequest.getCapacity())
                .status(zoneRequest.getStatus())
                .build();
    }
}
