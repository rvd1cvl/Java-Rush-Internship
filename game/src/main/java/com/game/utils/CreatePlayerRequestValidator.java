package com.game.utils;

import com.game.controller.response.CreatePlayerResponse;
import org.springframework.util.StringUtils;

public class CreatePlayerRequestValidator implements Validator {
    @Override
    public boolean validate(Object o) {
        if (!isApplicable(o)) {
            return false;
        }
        CreatePlayerResponse createPlayerResponse = (CreatePlayerResponse) o;
        if (StringUtils.isEmpty(createPlayerResponse.getName())) {
            return false;
        }

        if (createPlayerResponse.getName().length() > 12) {
            return false;
        }

        if (createPlayerResponse.getTitle().length() > 30) {
            return false;
        }

        if (createPlayerResponse.getExperience() < 0 || createPlayerResponse.getExperience() > 10000000) {
            return false;
        }

        if (StringUtils.isEmpty(createPlayerResponse.getTitle())) {
            return false;
        }

        if (createPlayerResponse.getRace() == null) {
            return false;
        }

        if (createPlayerResponse.getProfession() == null) {
            return false;
        }

        if (createPlayerResponse.getBirthday() < 0) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isApplicable(Object o) {

        return CreatePlayerRequestValidator.class.equals(o.getClass());
    }


}
