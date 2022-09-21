package com.game.utils;

import com.game.controller.requests.UpdatePlayerRequest;
import com.game.controller.response.UpdatePlayerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class UpdatePlayerRequestValidator implements Validator {

    private final Long id;

    public UpdatePlayerRequestValidator(Long id) {
        this.id = id;
    }

    @Override
    public boolean validate(Object o) {
        if (!isApplicable(o)) {
            return false;
        }
        if (id <= 0) {
            return false;
        }

        UpdatePlayerRequest updatePlayerRequest = (UpdatePlayerRequest) o;

        if (updatePlayerRequest.getName() == null && updatePlayerRequest.getTitle() == null
                && updatePlayerRequest.getProfession() == null && updatePlayerRequest.getBanned() == null
                && updatePlayerRequest.getExperience() == null && updatePlayerRequest.getLevel() == null
                && updatePlayerRequest.getBirthday() == null && updatePlayerRequest.getRace() == null) {
            return true;
        }

        if (updatePlayerRequest.getName() != null && updatePlayerRequest.getName().length() > 12) {
            return false;
        }

        if (updatePlayerRequest.getTitle() != null && updatePlayerRequest.getTitle().length() > 30) {
            return false;
        }

        if (updatePlayerRequest.getExperience() != null && (updatePlayerRequest.getExperience() < 0 || updatePlayerRequest.getExperience() > 10000000)) {
            return false;
        }

        if (updatePlayerRequest.getBirthday() != null && updatePlayerRequest.getBirthday() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isApplicable(Object o) {
        return UpdatePlayerRequest.class.equals(o.getClass());
    }
}
