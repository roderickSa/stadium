package com.home.stadium.service.stadiumService;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.stadium.domain.model.Stadium;
import com.home.stadium.domain.model.Zone;
import com.home.stadium.domain.model.ZoneStatus;
import com.home.stadium.exceptions.StadiumNotFoundException;
import com.home.stadium.exceptions.ZoneNotFoundException;
import com.home.stadium.infrastructure.request.ZoneRequest;
import com.home.stadium.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository stadiumRepository;

    public Stadium createStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public Stadium addZoneToStadium(UUID stadiumId, ZoneRequest zoneRequest) {
        Stadium stadium = stadiumRepository.findById(stadiumId)
            .orElseThrow(() -> new StadiumNotFoundException());

        Zone zone = Zone.builder()
                .stadium(stadium)
                .name(zoneRequest.getName())
                .capacity(zoneRequest.getCapacity())
                .status(zoneRequest.getStatus() != null ? zoneRequest.getStatus() : ZoneStatus.AVAILABLE)
                .description(zoneRequest.getDescription())
                .build();

        stadium.addZone(zone);
        return stadiumRepository.save(stadium);
    }

    public Stadium removeZoneFromStadium(UUID stadiumId, UUID zoneId) {
        Stadium stadium = stadiumRepository.findById(stadiumId)
            .orElseThrow(() -> new StadiumNotFoundException());

        Zone zone = stadium.getZones().stream()
            .filter(z -> z.getId().equals(zoneId))
            .findFirst()
            .orElseThrow(() -> new ZoneNotFoundException());

        stadium.removeZone(zone);
        return stadiumRepository.save(stadium);
    }

    @Transactional(readOnly = true)
    public Stadium getStadium(UUID id) {
        return stadiumRepository.findById(id)
            .orElseThrow(() -> new StadiumNotFoundException());
    }

    @Transactional(readOnly = true)
    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }
}
