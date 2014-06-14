package com.springapp.batch.mapper;

import com.springapp.batch.bo.BookEntry;
import com.springapp.batch.bo.Gender;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class BookEntryFieldSetMapper implements FieldSetMapper<BookEntry> {
    @Override
    public BookEntry mapFieldSet(FieldSet fieldSet) throws BindException {
        Gender sex = Gender.customValueOf(fieldSet.readString(1));

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yy");
        DateTime parsedDateOfBirth = dateTimeFormatter.parseDateTime(fieldSet.readString(2));

        BookEntry bookEntry = BookEntry.builder()
                .name(fieldSet.readString(0))
                .sex(sex)
                .dateOfBirth(parsedDateOfBirth)
                .build();

        return bookEntry;
    }
}
