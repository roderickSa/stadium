package com.home.stadium.external.apiFootball.client;

import java.util.List;

import com.home.stadium.external.apiFootball.dto.ApiFootballTeamDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFootballClient {
    @GET("/")
    Call<List<ApiFootballTeamDto>> getTeams(@Query(value = "action") String action, @Query(value = "league_id") String leagueId);
}
