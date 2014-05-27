package com.springapp.batch.writer;

import com.springapp.batch.bo.BookEntry;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookEntryWriter implements ItemWriter<BookEntry> {

    private static Logger logger = LoggerFactory.getLogger(BookEntryWriter.class);

    @Override
    public void write(List<? extends BookEntry> items) throws Exception {
        for (BookEntry currentPerson : items) {
            logger.debug(currentPerson.getName());
        }
    }

}
