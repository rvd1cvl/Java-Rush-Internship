package com.game.service.converter;

import com.game.controller.requests.CreatePlayerRequest;
import com.game.controller.requests.UpdatePlayerRequest;
import com.game.dto.PlayerDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RequestConverter {
    public PlayerDto convertToPlayerDto(CreatePlayerRequest createPlayerRequest) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName(createPlayerRequest.getName());
        playerDto.setBirthday(new Date(createPlayerRequest.getBirthday()));
        playerDto.setBanned(createPlayerRequest.getBanned());
        playerDto.setExperience(createPlayerRequest.getExperience());
        playerDto.setRace(createPlayerRequest.getRace());
        playerDto.setProfession(createPlayerRequest.getProfession());
        playerDto.setTitle(createPlayerRequest.getTitle());

        return playerDto;
    }

    public PlayerDto convertToPlayerDto(UpdatePlayerRequest updatePlayerRequest, Long id) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(id);
        playerDto.setName(updatePlayerRequest.getName());
        playerDto.setBirthday(updatePlayerRequest.getBirthday() == null ? null : new Date(updatePlayerRequest.getBirthday()));
        playerDto.setBanned(updatePlayerRequest.getBanned());
        playerDto.setExperience(updatePlayerRequest.getExperience());
        playerDto.setRace(updatePlayerRequest.getRace());
        playerDto.setProfession(updatePlayerRequest.getProfession());
        playerDto.setTitle(updatePlayerRequest.getTitle());

        return playerDto;
    }
}
