package com.springapp.batch.config;

import com.springapp.batch.mapper.BasicPersonFieldSetMapper;
import com.springapp.batch.mapper.PersonFieldSetMapper;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Autowired
    private PersonFieldSetMapper personFieldSetMapper;

    @Autowired
    private BasicPersonFieldSetMapper basicPersonFieldSetMapper;

    @Bean
    public LineTokenizer tokenizer() {
        return new DelimitedLineTokenizer();
    }

    @Bean
    public LineMapper personLineMapper() {
        return bootstrapLineMapper(personFieldSetMapper);
    }

    @Bean
    public LineMapper basicPersonLineMapper() {
        return bootstrapLineMapper(basicPersonFieldSetMapper);
    }

    private LineMapper bootstrapLineMapper(FieldSetMapper fieldSetMapper) {
        DefaultLineMapper mapper = new DefaultLineMapper();
        mapper.setFieldSetMapper(fieldSetMapper);
        mapper.setLineTokenizer(tokenizer());
        return mapper;
    }

}
