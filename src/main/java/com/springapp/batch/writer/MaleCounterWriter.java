package com.springapp.batch.writer;

import com.springapp.batch.bo.BasicPerson;
import com.springapp.batch.bo.Person;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MaleCounterWriter implements ItemWriter<BasicPerson>, StepExecutionListener {

    private static Logger logger = LoggerFactory.getLogger(MaleCounterWriter.class);

    private StepExecution stepExecution;

    private int males = 0;

    @Override
    public void write(List<? extends BasicPerson> items) throws Exception {
        for (BasicPerson currentPerson : items) {
            if (currentPerson.isMale()) {
                logger.debug("Found a male");
                males++;
            }
        }
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info("Total males: " + males);
        return ExitStatus.COMPLETED;
    }
}
