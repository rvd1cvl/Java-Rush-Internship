package com.game.service.converter;

import com.game.controller.response.CreatePlayerResponse;
import com.game.dto.PlayerDto;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {
    public CreatePlayerResponse convert(PlayerDto playerDto) {
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
}
