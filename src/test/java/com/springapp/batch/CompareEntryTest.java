package com.springapp.batch;

import com.springapp.batch.bo.BookEntry;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompareEntryTest {

    private static Logger logger = LoggerFactory.getLogger(CompareEntryTest.class);

    @Test
    public void testJob() throws Exception {
        BookEntry bill = mock(BookEntry.class);
        BookEntry paul = mock(BookEntry.class);

        when(bill.getDateOfBirth()).thenReturn(DateTime.parse("1970-01-08T12:30:49+05:30"));
        when(paul.getDateOfBirth()).thenReturn(DateTime.parse("1970-01-09T15:30:49+05:30"));

        Assert.assertEquals(1, bill.compareTo(paul));
    }

}
