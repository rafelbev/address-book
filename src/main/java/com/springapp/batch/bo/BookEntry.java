package com.springapp.batch.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * BO used to describe rows found insider the AddressBook
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntry {

    private String name;
    private Gender sex;
    private DateTime dateOfBirth;

    public BookEntry(String name, String sex, String dateOfBirth) {
        this();
        setName(name);
        setSex(Gender.customValueOf(sex));
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yy");
        DateTime parsedDateOfBirth = dateTimeFormatter.parseDateTime(dateOfBirth);
        setDateOfBirth(parsedDateOfBirth);
    }

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
