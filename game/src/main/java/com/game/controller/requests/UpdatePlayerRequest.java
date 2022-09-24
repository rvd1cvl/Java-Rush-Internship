package com.game.controller.requests;

public class UpdatePlayerRequest extends AbstractRequest {
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "UpdatePlayerRequest{" +
                "level=" + level +
                "} " + super.toString();
    }
}
