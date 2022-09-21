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
        playerDto.setId(player.getId());
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

    public Player convertForUpdating (PlayerDto playerToUpdate, PlayerDto playerDto) {
        Player updatedPlayer = new Player();
        updatedPlayer.setLevel(playerDto.getLevel() == null ? playerToUpdate.getLevel() : playerDto.getLevel());
        updatedPlayer.setName(playerDto.getName() == null ? playerToUpdate.getName() : playerDto.getName());
        updatedPlayer.setTitle(playerDto.getTitle() == null ? playerToUpdate.getTitle() : playerDto.getTitle());
        updatedPlayer.setRace(playerDto.getRace() == null ? playerToUpdate.getRace() : playerDto.getRace());
        updatedPlayer.setProfession(playerDto.getProfession() == null ? playerToUpdate.getProfession() : playerDto.getProfession());
        updatedPlayer.setExperience(playerDto.getExperience() == null ? playerToUpdate.getExperience() : playerDto.getExperience());
        updatedPlayer.setUntilNextLevel(playerDto.getUntilNextLevel() == null ? playerToUpdate.getUntilNextLevel() : playerDto.getUntilNextLevel());
        updatedPlayer.setBanned(playerDto.getBanned() == null ? playerToUpdate.getBanned() : playerDto.getBanned());
        updatedPlayer.setBirthday(playerDto.getBirthday() == null ? playerToUpdate.getBirthday() : playerDto.getBirthday());

        return updatedPlayer;
    }
}
