package com.springapp.batch.config;

import com.springapp.batch.mapper.PersonFieldSetMapper;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Autowired
    private PersonFieldSetMapper personFieldSetMapper;

    @Bean
    public LineTokenizer tokenizer() {
        return new DelimitedLineTokenizer();
    }

    @Bean
    public LineMapper lineMapper() {
        DefaultLineMapper mapper = new DefaultLineMapper();
        mapper.setFieldSetMapper(personFieldSetMapper);
        mapper.setLineTokenizer(tokenizer());
        return mapper;
    }
}
