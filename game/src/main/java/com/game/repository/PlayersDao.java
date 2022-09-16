package com.game.repository;

import com.game.controller.filters.PlayerFilter;
import com.game.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayersDao {
    public List<Player> getPlayers(PlayerFilter filter) {
        if (filter.getAfter() != null) {

        }

        if (filter.getBanned() != null) {

        }

        if (filter.getBefore() != null) {

        }

        if (filter.getName() != null) {

        }

        if (filter.getProfession() != null) {

        }

        if (filter.getMaxExperience() != null) {

        }

        if (filter.getMinExperience() != null) {

        }

        if (filter.getRace() != null) {

        }

        if (filter.getTitle() != null) {

        }

        if (filter.getPageNumber() != null) {

        }

        if (filter.getPageSize() != null) {

        }

        if (filter.getOrder() != null) {

        }

    }
}
