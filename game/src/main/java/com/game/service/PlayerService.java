package com.game.service;

import com.game.controller.filters.PlayerFilter;
import com.game.dto.PlayerDto;
import com.game.entity.Player;
import com.game.repository.PlayerRepository;
import com.game.repository.PlayersDao;
import com.game.service.converter.EntityConverter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final EntityConverter entityConverter;
    private final PlayersDao playersDao;


    public PlayerService(PlayerRepository playerRepository, EntityConverter entityConverter,
                         PlayersDao playersDao) {
        this.playerRepository = playerRepository;
        this.entityConverter = entityConverter;
        this.playersDao = playersDao;
    }

    public PlayerDto create(PlayerDto playerDto) {
        setLevelParams(playerDto);
        Player player = entityConverter.convert(playerDto);
        Player savedPlayer = playerRepository.save(player);

        return entityConverter.convert(savedPlayer);
    }

    public void delete(Long id) throws EmptyResultDataAccessException {
        playerRepository.deleteById(id);
    }

    @Nullable
    public PlayerDto update(PlayerDto playerDto) {
        PlayerDto currentPlayer = get(playerDto.getId());
        if (currentPlayer == null) {
            return null;
        }
        setLevelParams(playerDto);

        Player player = entityConverter.convert(playerDto);
        player.setId(playerDto.getId());
        Player editedPlayer = playerRepository.save(player);

        return entityConverter.convert(editedPlayer);
    }

    private void setLevelParams(PlayerDto playerDto) {
        int level = (int) ((Math.sqrt(2500 + 200 * playerDto.getExperience()) - 50) / 100);
        playerDto.setLevel(level);
        int untilNextLevel = 50 * (level + 1) * (level + 2) - playerDto.getExperience();
        playerDto.setUntilNextLevel(untilNextLevel);
    }

    @Nullable
    public PlayerDto get(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        Player player = optionalPlayer.orElse(null);
        if (player == null) {
            return null;
        }
        return entityConverter.convert(player);
    }

    public Integer getPlayersCount() {
        return (int) playerRepository.count();
    }

    public List<Player> getPlayers(PlayerFilter filter) {
        return playersDao.getPlayers(filter);
    }

}
