package com.game.controller.filters;

import com.game.controller.PlayerOrder;
import com.game.entity.Profession;
import com.game.entity.Race;

import java.util.Date;

public class PlayerFilter {
    private String name;
    private String title;
    private Race race;
    private Profession profession;
    private Date after;
    private Date before;
    private Boolean banned;
    private Integer minExperience;
    private Integer maxExperience;
    private Integer minLevel;
    private Integer maxLevel;
    private PlayerOrder order;
    private Integer pageNumber;
    private Integer pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Date getAfter() {
        return after;
    }

    public void setAfter(Date after) {
        this.after = after;
    }

    public Date getBefore() {
        return before;
    }

    public void setBefore(Date before) {
        this.before = before;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public Integer getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(Integer minExperience) {
        this.minExperience = minExperience;
    }

    public Integer getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(Integer maxExperience) {
        this.maxExperience = maxExperience;
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public PlayerOrder getOrder() {
        return order;
    }

    public void setOrder(PlayerOrder order) {
        this.order = order;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PlayerFilter{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", race=" + race +
                ", profession=" + profession +
                ", after=" + after +
                ", before=" + before +
                ", banned=" + banned +
                ", minExperience=" + minExperience +
                ", maxExperience=" + maxExperience +
                ", minLevel=" + minLevel +
                ", maxLevel=" + maxLevel +
                ", order=" + order +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
