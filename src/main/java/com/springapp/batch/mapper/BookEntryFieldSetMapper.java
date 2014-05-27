package com.springapp.batch.mapper;

import com.springapp.batch.bo.BookEntry;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class BookEntryFieldSetMapper implements FieldSetMapper<BookEntry> {
    @Override
    public BookEntry mapFieldSet(FieldSet fieldSet) throws BindException {
        BookEntry bookEntry = new BookEntry(fieldSet.readString(0), fieldSet.readString(1), fieldSet.readString(2));
        return bookEntry;
    }
}
