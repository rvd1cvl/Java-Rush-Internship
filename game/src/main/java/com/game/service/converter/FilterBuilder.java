package com.game.service.converter;

import com.game.controller.PlayerOrder;
import com.game.controller.filters.PlayerFilter;
import com.game.entity.Profession;
import com.game.entity.Race;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FilterBuilder {
    public PlayerFilter createFilter(String name, String title, Race race, Profession profession, Long after,
                                     Long before, Boolean banned, Integer minExperience, Integer maxExperience,
                                     Integer minLevel, Integer maxLevel, PlayerOrder order, Integer pageNumber,
                                     Integer pageSize) {
        PlayerFilter filter = new PlayerFilter();

        filter.setName(name);
        filter.setTitle(title);
        filter.setRace(race);
        filter.setProfession(profession);
        filter.setAfter(after == null ? null : new Date(after));
        filter.setBefore(before == null ? null : new Date(before));
        filter.setBanned(banned);
        filter.setMinExperience(minExperience);
        filter.setMaxExperience(maxExperience);
        filter.setMinLevel(minLevel);
        filter.setMaxLevel(maxLevel);
        filter.setOrder(order == null ? PlayerOrder.ID : order);
        filter.setPageNumber(pageNumber == null ? 0 : pageNumber);
        filter.setPageSize(pageSize == null ? 3 : pageSize);

        return filter;
    }
}
