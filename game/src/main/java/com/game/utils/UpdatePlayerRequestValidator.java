package com.game.utils;

import com.game.controller.requests.UpdatePlayerRequest;
import com.game.controller.response.UpdatePlayerResponse;
import org.springframework.util.StringUtils;

public class UpdatePlayerRequestValidator implements Validator {

    @Override
    public boolean validate(Object o) {
        if (!isApplicable(o)) {
            return false;
        }

        UpdatePlayerRequest updatePlayerRequest = (UpdatePlayerRequest) o;


        if (updatePlayerRequest.getName() != null && updatePlayerRequest.getName().length() > 12) {
            return false;
        }

        if (updatePlayerRequest.getTitle() != null && updatePlayerRequest.getTitle().length() > 30) {
            return false;
        }

        if (updatePlayerRequest.getExperience() < 0 || updatePlayerRequest.getExperience() > 10000000) {
            return false;
        }

        if (updatePlayerRequest.getBirthday() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isApplicable(Object o) {
        return UpdatePlayerRequest.class.equals(o.getClass());
    }
}
