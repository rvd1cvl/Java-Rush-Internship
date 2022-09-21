package com.game.service.converter;

import com.game.controller.response.*;
import com.game.dto.PlayerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponseConverter {
    public CreatePlayerResponse convertToCreatePlayerResponse(PlayerDto playerDto) {
        CreatePlayerResponse createPlayerResponse = new CreatePlayerResponse();
        createPlayerResponse.setId(playerDto.getId());
        createPlayerResponse.setName(playerDto.getName());
        createPlayerResponse.setBirthday(playerDto.getBirthday().getTime());
        createPlayerResponse.setBanned(playerDto.getBanned());
        createPlayerResponse.setExperience(playerDto.getExperience());
        createPlayerResponse.setRace(playerDto.getRace());
        createPlayerResponse.setProfession(playerDto.getProfession());
        createPlayerResponse.setTitle(playerDto.getTitle());
        createPlayerResponse.setLevel(playerDto.getLevel());
        createPlayerResponse.setUntilNextLevel(playerDto.getUntilNextLevel());

        return createPlayerResponse;
    }

    public UpdatePlayerResponse convertToUpdatePlayerResponse(PlayerDto playerDto) {
        UpdatePlayerResponse updatePlayerResponse = new UpdatePlayerResponse();
        updatePlayerResponse.setId(playerDto.getId());
        updatePlayerResponse.setName(playerDto.getName());
        updatePlayerResponse.setBirthday(playerDto.getBirthday().getTime());
        updatePlayerResponse.setBanned(playerDto.getBanned());
        updatePlayerResponse.setExperience(playerDto.getExperience());
        updatePlayerResponse.setRace(playerDto.getRace());
        updatePlayerResponse.setProfession(playerDto.getProfession());
        updatePlayerResponse.setTitle(playerDto.getTitle());
        updatePlayerResponse.setLevel(playerDto.getLevel());
        updatePlayerResponse.setUntilNextLevel(playerDto.getUntilNextLevel());

        return updatePlayerResponse;
    }

    public GetPlayerResponse convertToGetPlayerResponse(PlayerDto playerDto) {
        GetPlayerResponse getPlayerResponse = new GetPlayerResponse();

        getPlayerResponse.setId(playerDto.getId());
        getPlayerResponse.setName(playerDto.getName());
        getPlayerResponse.setBirthday(playerDto.getBirthday().getTime());
        getPlayerResponse.setBanned(playerDto.getBanned());
        getPlayerResponse.setExperience(playerDto.getExperience());
        getPlayerResponse.setRace(playerDto.getRace());
        getPlayerResponse.setProfession(playerDto.getProfession());
        getPlayerResponse.setTitle(playerDto.getTitle());
        getPlayerResponse.setLevel(playerDto.getLevel());
        getPlayerResponse.setUntilNextLevel(playerDto.getUntilNextLevel());

        return getPlayerResponse;
    }

    public GetAllPlayersResponse convertToGetAllPlayersResponse(List<PlayerDto> players) {
        List<GetPlayerResponse> result = players.stream().map(this::convertToGetPlayerResponse).collect(Collectors.toList());
        GetAllPlayersResponse getAllPlayersResponse = new GetAllPlayersResponse();
        getAllPlayersResponse.setGetPlayerResponseList(result);

        return getAllPlayersResponse;
    }
}
