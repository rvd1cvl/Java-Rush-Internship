package com.game.utils;

import com.game.controller.response.UpdatePlayerResponse;
import org.springframework.util.StringUtils;

public class UpdatePlayerRequestValidator implements Validator {

    @Override
    public boolean validate(Object o) {
        if (!isApplicable(o)) {
            return false;
        }

        UpdatePlayerResponse updatePlayerResponse = (UpdatePlayerResponse) o;


        if (updatePlayerResponse.getName() != null && updatePlayerResponse.getName().length() > 12) {
            return false;
        }

        if (updatePlayerResponse.getTitle() != null && updatePlayerResponse.getTitle().length() > 30) {
            return false;
        }

        if (updatePlayerResponse.getExperience() < 0 || updatePlayerResponse.getExperience() > 10000000) {
            return false;
        }

        if (updatePlayerResponse.getBirthday() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isApplicable(Object o) {
        return UpdatePlayerRequestValidator.class.equals(o.getClass());
    }
}
