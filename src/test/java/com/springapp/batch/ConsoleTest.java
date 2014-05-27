package com.springapp.batch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ConsoleTest {

    private static Logger logger = LoggerFactory.getLogger(ConsoleTest.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("mainJob")
    private Job job;

    @Test
    public void testJob() throws Exception {
        JobParametersBuilder builder = new JobParametersBuilder();
        JobExecution jobExecution = jobLauncher.run(job, builder.toJobParameters());
        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
        logger.debug(jobExecution.getExitStatus().getExitCode());
    }

}
