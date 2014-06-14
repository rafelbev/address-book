package com.springapp.batch;

import com.springapp.batch.bo.Person;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompareEntryTest {

    public static final String BILL_DOB = "1970-01-08T12:30:49+05:30";
    public static final String PAUL_DOB = "1970-01-09T15:30:49+05:30";

    /**
     * This test implements Task 3 of the assignment
     * If this fails we don't get the job
     *
     * @throws Exception
     */
    @Test
    public void testAssignmentTask() throws Exception {
        Person bill = mock(Person.class);
        Person paul = mock(Person.class);

        when(bill.getDateOfBirth()).thenReturn(DateTime.parse(BILL_DOB));
        when(paul.getDateOfBirth()).thenReturn(DateTime.parse(PAUL_DOB));

        Assert.assertEquals(1, bill.compareTo(paul));
    }

}
