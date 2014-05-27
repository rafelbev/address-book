package com.springapp.batch.bo;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * BO used to describe rows found insider the AddressBook
 */
@Data
public class BookEntry {

    private String name;
    private Gender sex;
    private DateTime dateOfBirth;

}
