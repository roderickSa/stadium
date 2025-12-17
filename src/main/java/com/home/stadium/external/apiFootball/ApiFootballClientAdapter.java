package com.home.stadium.external.apiFootball;

import java.util.List;

import org.springframework.stereotype.Component;

import com.home.stadium.domain.model.Team;
import com.home.stadium.exceptions.ApiFootballServerException;
import com.home.stadium.exceptions.ApiFootballUnauthorizedException;
import com.home.stadium.external.apiFootball.client.ApiFootballClient;
import com.home.stadium.external.apiFootball.dto.ApiFootballTeamDto;
import com.home.stadium.external.apiFootball.mapper.ApiFootballTeamMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiFootballClientAdapter {
    private final ApiFootballClient apiFootballClient;

    public List<Team> getTeams(String leagueId) {
        try {
            Response<List<ApiFootballTeamDto>> response = apiFootballClient.getTeams("get_teams", leagueId).execute();

            if (!response.isSuccessful()) {
                handleErrorResponse(response.code());
            }

            if (response.body() == null) {
                throw new ApiFootballServerException();
            }

            return ApiFootballTeamMapper.toResponseList(response.body());
        } catch (Exception e) {
            log.error("Error fetching teams from API Football", e);
            throw new ApiFootballServerException();
        }
    }

    private void handleErrorResponse(int statusCode) {
    switch (statusCode) {
        case 401, 403 -> throw new ApiFootballUnauthorizedException();
        case 500, 502, 503, 504 -> throw new ApiFootballServerException();
        default -> throw new ApiFootballServerException();
    }
}
}
