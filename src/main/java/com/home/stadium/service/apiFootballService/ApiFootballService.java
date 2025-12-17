package com.home.stadium.service.apiFootballService;

import java.util.List;

import com.home.stadium.domain.model.Team;

public interface ApiFootballService {
    List<Team> getTeams(String leagueId);
}
