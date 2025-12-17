package com.home.stadium.infrastructure.mapper;

import java.util.List;

import com.home.stadium.domain.model.Team;
import com.home.stadium.infrastructure.response.TeamResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamMapper {
    public static TeamResponse toResponse(Team team) {
        if (team == null) {
            return null;
        }

        return TeamResponse.builder()
                .key(team.getKey())
                .name(team.getName())
                .country(team.getCountry())
                .founded(team.getFounded())
                .badgeUrl(team.getBadgeUrl())
                .venue(VenueMapper.toResponse(team.getVenue()))
                .build();
    }

    public static List<TeamResponse> toResponseList(List<Team> teams) {
        return teams.stream()
                .map(TeamMapper::toResponse)
                .toList();
    }
}
