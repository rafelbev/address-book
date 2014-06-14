package com.springapp.batch.mapper;

import com.springapp.batch.bo.Person;
import com.springapp.batch.bo.Gender;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PersonFieldSetMapper implements FieldSetMapper<Person> {
    @Override
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {
        Gender sex = Gender.customValueOf(fieldSet.readString(1));

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yy");
        DateTime parsedDateOfBirth = dateTimeFormatter.parseDateTime(fieldSet.readString(2));

        Person person = Person.builder()
                .name(fieldSet.readString(0))
                .dateOfBirth(parsedDateOfBirth)
                .build();
        person.setSex(sex);

        return person;
    }
}
