package com.sda.service;

import com.sda.service.WriteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by RENT on 2017-08-28.
 */
public class WriteServiceTest {

    private WriteService writeService;

    @Before
    public void init() {
        writeService = new WriteService();
    }

    @Test
    public void shouldReturnMessageWithGivenName() {

        //given
        String givenName = "Bartek";

        //when
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, " + givenName;

        //then
        Assert.assertEquals("Messages are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithNamAsNull() {

        //given
        String givenName = null;

        //when
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, my friend";

        //then
        Assert.assertEquals("Messages for null name are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithEmptyName() {

        //given
        String givenName = "";

        //when
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, my friend";

        //then
        Assert.assertEquals("Messages for null name are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnShoutMessageWithGivenCapitalName() {

        //given
        String givenName = "ANNA";

        //when
        String actualValue = writeService.action(givenName);
        String expectedValue = "HELLO, ANNA!";

        //then
        Assert.assertEquals("Messages for null name are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithGivenNameFilledWithSpaces() {

        //given
        String givenName = "      ";

        //when
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, my friend";

        //then
        Assert.assertEquals("Messages for null name are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageForGivenMultipleNamea() {

        //given
        String givenName = "John, Martin, Ela";

        //when
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, John, Martin and Ela";

        //then
        Assert.assertEquals("Messages are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnShoutMessageForGivenCapitalMultipleNamea() {

        //given
        String givenName = "JOHN, MARTIN, ELA";

        //when
        String actualValue = writeService.action(givenName);
        String expectedValue = "HELLO, JOHN, MARTIN and ELA!";

        //then
        Assert.assertEquals("Messages are not the same!", expectedValue, actualValue);
    }

}
