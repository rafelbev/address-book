package com.springapp.batch.bo;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * ENUM for different types of Gender
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    @Getter
    private final String label;

    public static Gender customValueOf(String sex) {
        if (isNotBlank(sex)) {
            return Gender.valueOf(sex.toUpperCase());
        }
        return null;
    }
}
