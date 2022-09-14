package com.game.service;

import com.game.entity.Player;
import com.game.repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void create(Player player) {
        playerRepository.save(player);
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    public void update(Player player) {
        playerRepository.save(player);
    }

    @Nullable
    public Player get(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        return optionalPlayer.orElse(null);
    }

    public Long getPlayersCount() {
        return playerRepository.count();
    }

    public List<Player> getPlayers(int pageNumber, int pageSize) {
        Page<Player> page = playerRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return page.toList();
    }




}
