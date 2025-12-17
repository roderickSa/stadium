package com.home.stadium.service.apiFootballService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.stadium.domain.model.Team;
import com.home.stadium.external.apiFootball.ApiFootballClientAdapter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiFootballServiceImpl implements ApiFootballService {

    private final ApiFootballClientAdapter apiFootballClientAdapter;

    public List<Team> getTeams(String leagueId) {
        return apiFootballClientAdapter.getTeams(leagueId);
    }
}
