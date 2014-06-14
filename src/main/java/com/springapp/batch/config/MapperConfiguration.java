package com.springapp.batch.config;

import com.springapp.batch.mapper.PersonFieldSetMapper;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public FieldSetMapper personFieldsetMapper() {
        return new PersonFieldSetMapper();
    }

    @Bean
    public LineTokenizer tokenizer() {
        return new DelimitedLineTokenizer();
    }

    @Bean
    public LineMapper lineMapper() {
        DefaultLineMapper mapper = new DefaultLineMapper();
        mapper.setFieldSetMapper(personFieldsetMapper());
        mapper.setLineTokenizer(tokenizer());
        return mapper;
    }
}
