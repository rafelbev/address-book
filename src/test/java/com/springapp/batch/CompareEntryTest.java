package com.springapp.batch;

import com.springapp.batch.bo.Person;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.fail;
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

        when(bill.compareTo(paul)).thenCallRealMethod();

        Assert.assertEquals(1, bill.compareTo(paul));
    }

    @Test
    public void testNullParameter() throws Exception {
        Person bill = mock(Person.class);
        Person invalidPerson = null;

        when(bill.getDateOfBirth()).thenReturn(DateTime.parse(BILL_DOB));

        when(bill.compareTo(invalidPerson)).thenCallRealMethod();

        try {
            bill.compareTo(invalidPerson);
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
    }

    @Test
    public void testInvalidDateInParameter() throws Exception {
        Person bill = mock(Person.class);
        Person invalidPerson = mock(Person.class);

        when(bill.getDateOfBirth()).thenReturn(DateTime.parse(BILL_DOB));
        when(invalidPerson.getDateOfBirth()).thenReturn(null);
        when(bill.compareTo(invalidPerson)).thenCallRealMethod();

        try {
            bill.compareTo(invalidPerson);
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
    }


    @Test
    public void testInvalidDateInObject() throws Exception {
        Person invalidPerson = mock(Person.class);
        Person bill = mock(Person.class);

        when(invalidPerson.getDateOfBirth()).thenReturn(null);
        when(bill.getDateOfBirth()).thenReturn(DateTime.parse(BILL_DOB));

        when(invalidPerson.compareTo(bill)).thenCallRealMethod();

        try {
            invalidPerson.compareTo(bill);
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
    }
}
