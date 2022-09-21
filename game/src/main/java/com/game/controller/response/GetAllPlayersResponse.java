package com.game.controller.response;

import java.util.List;

public class GetAllPlayersResponse {
    List<GetPlayerResponse> getPlayerResponseList;

    public List<GetPlayerResponse> getGetPlayerResponseList() {
        return getPlayerResponseList;
    }

    public void setGetPlayerResponseList(List<GetPlayerResponse> getPlayerResponseList) {
        this.getPlayerResponseList = getPlayerResponseList;
    }

    @Override
    public String toString() {
        return getPlayerResponseList.toString();
    }
}
