package com.game.utils;

import com.game.controller.requests.CreatePlayerRequest;
import com.game.controller.response.CreatePlayerResponse;
import org.springframework.util.StringUtils;

public class CreatePlayerRequestValidator implements Validator {
    @Override
    public boolean validate(Object o) {
        if (!isApplicable(o)) {
            return false;
        }
        CreatePlayerRequest createPlayerRequest = (CreatePlayerRequest) o;
        if (StringUtils.isEmpty(createPlayerRequest.getName())) {
            return false;
        }

        if (createPlayerRequest.getName().length() > 12) {
            return false;
        }

        if (createPlayerRequest.getTitle().length() > 30) {
            return false;
        }

        if (createPlayerRequest.getExperience() < 0 || createPlayerRequest.getExperience() > 10000000) {
            return false;
        }

        if (StringUtils.isEmpty(createPlayerRequest.getTitle())) {
            return false;
        }

        if (createPlayerRequest.getRace() == null) {
            return false;
        }

        if (createPlayerRequest.getProfession() == null) {
            return false;
        }

        if (createPlayerRequest.getBirthday() < 0) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isApplicable(Object o) {

        return CreatePlayerRequest.class.equals(o.getClass());
    }


}
