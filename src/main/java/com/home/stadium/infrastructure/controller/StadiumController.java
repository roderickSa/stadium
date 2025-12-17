package com.home.stadium.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.stadium.domain.model.Stadium;
import com.home.stadium.infrastructure.mapper.StadiumRequestMapper;
import com.home.stadium.infrastructure.mapper.StadiumResponseMapper;
import com.home.stadium.infrastructure.request.StadiumRequest;
import com.home.stadium.infrastructure.request.ZoneRequest;
import com.home.stadium.infrastructure.response.StadiumResponse;
import com.home.stadium.service.stadiumService.StadiumService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("stadiums")
@Validated
public class StadiumController {
    private final StadiumService stadiumService;

    @GetMapping()
    public ResponseEntity<List<StadiumResponse>> retrieveAllStadiums(){
        List<Stadium> stadiums = stadiumService.getAllStadiums();
        return ResponseEntity.ok(StadiumResponseMapper.toResponseList(stadiums));
    }

    @GetMapping("/{stadiumId}")
    public ResponseEntity<StadiumResponse> retrieveStadium(@PathVariable UUID stadiumId){
        Stadium stadium = stadiumService.getStadium(stadiumId);
        return ResponseEntity.ok(StadiumResponseMapper.toResponse(stadium));
    }

    @PostMapping()
    public ResponseEntity<StadiumResponse> createStadium(@Valid @RequestBody StadiumRequest request){
        Stadium stadium = stadiumService.createStadium(StadiumRequestMapper.toRequest(request));
        return ResponseEntity.ok(StadiumResponseMapper.toResponse(stadium));
    }

    @PostMapping("/{stadiumId}/addZone")
    public ResponseEntity<StadiumResponse> addZoneToStadium(@PathVariable UUID stadiumId, @Valid @RequestBody ZoneRequest request){
        Stadium stadium = stadiumService.addZoneToStadium(stadiumId, request);
        return ResponseEntity.ok(StadiumResponseMapper.toResponse(stadium));
    }

    @PostMapping("/{stadiumId}/removeZone/{zoneId}")
    public ResponseEntity<StadiumResponse> removeZoneFromStadium(@PathVariable UUID stadiumId, @PathVariable UUID zoneId){
        Stadium stadium = stadiumService.removeZoneFromStadium(stadiumId, zoneId);
        return ResponseEntity.ok(StadiumResponseMapper.toResponse(stadium));
    }
}
