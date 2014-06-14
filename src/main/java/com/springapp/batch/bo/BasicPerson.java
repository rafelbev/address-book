package com.springapp.batch.bo;

import lombok.Data;

/**
 * BO used to describe just the gender in a row found insider the AddressBook
 */
@Data
public class BasicPerson {

    private Gender sex;

    public boolean isMale() {
        if (sex != null) {
            if (sex.equals(Gender.MALE)) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new RuntimeException("Sex of entry is unknown");
        }
    }
}
