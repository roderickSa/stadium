package com.home.stadium.external.apiFootball.mapper;

import java.util.List;

import com.home.stadium.domain.model.Team;
import com.home.stadium.external.apiFootball.dto.ApiFootballTeamDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiFootballTeamMapper {
    public static Team toResponse(ApiFootballTeamDto team) {
        if (team == null) {
            return null;
        }

        return Team.builder()
                .key(team.getKey())
                .name(team.getName())
                .country(team.getCountry())
                .founded(team.getFounded())
                .badgeUrl(team.getBadgeUrl())
                .venue(ApiFootballVenueMapper.toResponse(team.getVenue()))
                .build();
    }

    public static List<Team> toResponseList(List<ApiFootballTeamDto> teams) {
        return teams.stream()
                .map(ApiFootballTeamMapper::toResponse)
                .toList();
    }
}
