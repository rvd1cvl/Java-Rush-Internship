package com.game.utils;

public class GetPlayerValidator implements Validator {

    @Override
    public boolean validate(Object o) {
        if (!isApplicable(o)) {
            return false;
        }

        Long id = (Long) o;
        if (id <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isApplicable(Object o) {
        return Long.class.equals(o.getClass());
    }
}
