package com.springapp.batch.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.Serializable;

/**
 * BO used to describe all fields in a row found insider the AddressBook
 */
@Data
@NoArgsConstructor
@Builder(fluent = true)
@AllArgsConstructor
public class Person extends BasicPerson implements Serializable, Comparable<Person> {

    private String name;
    private DateTime dateOfBirth;

    public boolean isOlder(Person otherEntry) {
        if (otherEntry == null) {
            return true;
        }
        if ((getDateOfBirth() == null) || (otherEntry.getDateOfBirth() == null)) {
            throw new RuntimeException("DOB is missing. Can't evaluate if the person is older");
        }
        return (getDateOfBirth().isBefore(otherEntry.getDateOfBirth()));
    }

    @Override
    public int compareTo(Person otherEntry) {
        if (otherEntry == null) {
            throw new RuntimeException("Missing object to compareTo");
        }
        if ((getDateOfBirth() == null) || (otherEntry.getDateOfBirth() == null)) {
            throw new RuntimeException("DOB is missing. Can't evaluate if the person is older");
        }
        return Days.daysBetween(getDateOfBirth(), getDateOfBirth()).getDays();
    }
}
