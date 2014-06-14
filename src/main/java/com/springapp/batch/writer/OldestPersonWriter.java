package com.springapp.batch.writer;

import com.springapp.batch.bo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class OldestPersonWriter implements ItemWriter<Person>, StepExecutionListener{

    private static Logger logger = LoggerFactory.getLogger(OldestPersonWriter.class);

    private StepExecution stepExecution;

    private Person oldestPerson = null;

    @Override
    public void write(List<? extends Person> items) throws Exception {
        for (Person currentPerson : items) {
            if (currentPerson.isOlder(oldestPerson)) {
                oldestPerson = currentPerson;
            }
        }
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info("Oldest person: " + oldestPerson.toString());
        return ExitStatus.COMPLETED;
    }
}
