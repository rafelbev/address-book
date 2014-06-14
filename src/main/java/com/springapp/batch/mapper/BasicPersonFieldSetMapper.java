package com.springapp.batch.mapper;

import com.springapp.batch.bo.BasicPerson;
import com.springapp.batch.bo.Gender;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component
public class BasicPersonFieldSetMapper implements FieldSetMapper<BasicPerson> {
    @Override
    public BasicPerson mapFieldSet(FieldSet fieldSet) throws BindException {
        Gender sex = Gender.customValueOf(fieldSet.readString(1));

        BasicPerson person = new BasicPerson();
        person.setSex(sex);

        return person;
    }
}
