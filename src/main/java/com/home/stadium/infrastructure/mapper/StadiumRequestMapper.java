package com.home.stadium.infrastructure.mapper;

import com.home.stadium.domain.model.Stadium;
import com.home.stadium.infrastructure.request.StadiumRequest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StadiumRequestMapper {
    public static Stadium toRequest(StadiumRequest stadiumRequest) {
        return Stadium.builder()
                .name(stadiumRequest.getName())
                .description(stadiumRequest.getDescription())
                .build();
    }
}
