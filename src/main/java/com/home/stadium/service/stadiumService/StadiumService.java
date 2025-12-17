package com.home.stadium.service.stadiumService;

import java.util.List;
import java.util.UUID;

import com.home.stadium.domain.model.Stadium;
import com.home.stadium.infrastructure.request.ZoneRequest;

public interface StadiumService {
    Stadium createStadium(Stadium stadium);
    Stadium addZoneToStadium(UUID stadiumId, ZoneRequest zoneRequest);
    Stadium removeZoneFromStadium(UUID stadiumId, UUID zoneId);
    Stadium getStadium(UUID id);
    List<Stadium> getAllStadiums();
}
