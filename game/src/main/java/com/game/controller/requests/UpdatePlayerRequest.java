package com.game.controller.requests;

import com.game.entity.Profession;
import com.game.entity.Race;

public class UpdatePlayerRequest {
    private String name;
    private String title;
    private Race race;
    private Profession profession;
    private Long birthday;
    private Boolean isBanned;
    private Integer experience;

    public UpdatePlayerRequest() {}

    public UpdatePlayerRequest(String name, String title, Race race, Profession profession, Long birthday,
                               Boolean isBanned, Integer experience) {
        this.name = name;
        this.title = title;
        this.race = race;
        this.profession = profession;
        this.birthday = birthday;
        this.isBanned = isBanned;
        this.experience = experience;
    }

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

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "UpdatePlayerRequest{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", race=" + race +
                ", profession=" + profession +
                ", birthday=" + birthday +
                ", isBanned=" + isBanned +
                ", experience=" + experience +
                '}';
    }
}
