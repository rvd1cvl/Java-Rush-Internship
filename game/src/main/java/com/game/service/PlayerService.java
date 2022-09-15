package com.game.service;

import com.game.dto.PlayerDto;
import com.game.entity.Player;
import com.game.repository.PlayerRepository;
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


    public PlayerService(PlayerRepository playerRepository, EntityConverter entityConverter) {
        this.playerRepository = playerRepository;
        this.entityConverter = entityConverter;
    }

    public PlayerDto create(PlayerDto playerDto) {
        int level = (int) ((Math.sqrt(2500 + 200 * playerDto.getExperience()) - 50) / 100);
        playerDto.setLevel(level);
        int untilNextLevel = 50 * (level + 1) * (level + 2) - playerDto.getExperience();
        playerDto.setUntilNextLevel(untilNextLevel);
        Player player = entityConverter.convert(playerDto);
        Player savedPlayer = playerRepository.save(player);

        return entityConverter.convert(savedPlayer);
    }

    public void delete(Long id) throws EmptyResultDataAccessException {
        playerRepository.deleteById(id);
    }

    @Nullable
    public PlayerDto update(PlayerDto playerDto) {

        if (get(playerDto.getId()) == null) {
            return null;
        }

        Player player = entityConverter.convert(playerDto);
        player.setId(playerDto.getId());
        Player editedPlayer = playerRepository.save(player);

        return entityConverter.convert(editedPlayer);
    }

    @Nullable
    public Player get(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        return optionalPlayer.orElse(null);
    }

    public Integer getPlayersCount() {
        return (int) playerRepository.count();
    }

    public List<Player> getPlayers(int pageNumber, int pageSize) {
        Page<Player> page = playerRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return page.toList();
    }
}
