package com.game.service.converter;

import com.game.controller.requests.CreatePlayerRequest;
import com.game.dto.PlayerDto;
import com.game.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {
    public Player convert (PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setBirthday(playerDto.getBirthday());
        player.setBanned(playerDto.getBanned());
        player.setExperience(playerDto.getExperience());
        player.setRace(playerDto.getRace());
        player.setProfession(playerDto.getProfession());
        player.setTitle(playerDto.getTitle());
        player.setLevel(playerDto.getLevel());
        player.setExperience(playerDto.getExperience());
        player.setUntilNextLevel(playerDto.getUntilNextLevel());

        return player;
    }

    public PlayerDto convert (Player player) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName(player.getName());
        playerDto.setBirthday(player.getBirthday());
        playerDto.setBanned(player.getBanned());
        playerDto.setExperience(player.getExperience());
        playerDto.setRace(player.getRace());
        playerDto.setProfession(player.getProfession());
        playerDto.setTitle(player.getTitle());
        playerDto.setLevel(player.getLevel());
        playerDto.setExperience(player.getExperience());
        playerDto.setUntilNextLevel(player.getUntilNextLevel());

        return playerDto;
    }
}
