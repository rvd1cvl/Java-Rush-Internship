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

        applyFields(createPlayerResponse, playerDto);

        return createPlayerResponse;
    }

    public UpdatePlayerResponse convertToUpdatePlayerResponse(PlayerDto playerDto) {
        UpdatePlayerResponse updatePlayerResponse = new UpdatePlayerResponse();

        applyFields(updatePlayerResponse, playerDto);

        return updatePlayerResponse;
    }

    public GetPlayerResponse convertToGetPlayerResponse(PlayerDto playerDto) {
        GetPlayerResponse getPlayerResponse = new GetPlayerResponse();

        applyFields(getPlayerResponse, playerDto);
        return getPlayerResponse;
    }

    public List<GetPlayerResponse> convertToGetAllPlayersResponse(List<PlayerDto> players) {
        return players.stream().map(this::convertToGetPlayerResponse).collect(Collectors.toList());
    }

    private void applyFields(AbstractResponse abstractResponse, PlayerDto playerDto) {
        abstractResponse.setId(playerDto.getId());
        abstractResponse.setName(playerDto.getName());
        abstractResponse.setBirthday(playerDto.getBirthday().getTime());
        abstractResponse.setBanned(playerDto.getBanned());
        abstractResponse.setExperience(playerDto.getExperience());
        abstractResponse.setRace(playerDto.getRace());
        abstractResponse.setProfession(playerDto.getProfession());
        abstractResponse.setTitle(playerDto.getTitle());
        abstractResponse.setLevel(playerDto.getLevel());
        abstractResponse.setUntilNextLevel(playerDto.getUntilNextLevel());
    }
}
