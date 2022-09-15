package com.game.service.converter;

import com.game.controller.response.CreatePlayerResponse;
import com.game.controller.response.UpdatePlayerResponse;
import com.game.dto.PlayerDto;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {
    public CreatePlayerResponse convertToCreatePlayerResponse(PlayerDto playerDto) {
        CreatePlayerResponse createPlayerResponse = new CreatePlayerResponse();
        createPlayerResponse.setName(playerDto.getName());
        createPlayerResponse.setBirthday(playerDto.getBirthday().getTime());
        createPlayerResponse.setBanned(playerDto.getBanned());
        createPlayerResponse.setExperience(playerDto.getExperience());
        createPlayerResponse.setRace(playerDto.getRace());
        createPlayerResponse.setProfession(playerDto.getProfession());
        createPlayerResponse.setTitle(playerDto.getTitle());

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
}
