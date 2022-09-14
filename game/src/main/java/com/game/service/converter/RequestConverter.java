package com.game.service.converter;

import com.game.controller.requests.CreatePlayerRequest;
import com.game.dto.PlayerDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RequestConverter {
    public PlayerDto convert(CreatePlayerRequest createPlayerRequest) {
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
}
