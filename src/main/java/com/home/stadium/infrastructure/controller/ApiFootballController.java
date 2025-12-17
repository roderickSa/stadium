package com.home.stadium.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.stadium.domain.model.Team;
import com.home.stadium.infrastructure.mapper.TeamMapper;
import com.home.stadium.infrastructure.response.TeamResponse;
import com.home.stadium.service.apiFootballService.ApiFootballService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("teams")
public class ApiFootballController {
    private final ApiFootballService apiFootballService;

    @GetMapping()
    public ResponseEntity<List<TeamResponse>> retrieveAllTeams(
            @RequestParam(required = true) String leagueId) {
        List<Team> teams = apiFootballService.getTeams(leagueId);

        return ResponseEntity.ok(TeamMapper.toResponseList(teams));
    }
}
