package com.springapp.batch.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.Serializable;

/**
 * BO used to describe rows found insider the AddressBook
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookEntry implements Serializable, Comparable<BookEntry> {

    private String name;
    private Gender sex;
    private DateTime dateOfBirth;

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

    public boolean isOlder(BookEntry otherEntry) {
        if (otherEntry == null) {
            return true;
        }
        if ((getDateOfBirth() == null) || (otherEntry.getDateOfBirth() == null)) {
            throw new RuntimeException("DOB is missing. Can't evaluate if the person is older");
        }
        return (getDateOfBirth().isBefore(otherEntry.getDateOfBirth()));
    }

    @Override
    public int compareTo(BookEntry otherEntry) {
        if (otherEntry == null) {
            throw new RuntimeException("Missing object to compareTo");
        }
        if ((getDateOfBirth() == null) || (otherEntry.getDateOfBirth() == null)) {
            throw new RuntimeException("DOB is missing. Can't evaluate if the person is older");
        }
        return Days.daysBetween(getDateOfBirth(), getDateOfBirth()).getDays();
    }
}
