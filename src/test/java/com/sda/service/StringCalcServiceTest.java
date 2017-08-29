package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by RENT on 2017-08-29.
 */
public class StringCalcServiceTest {

    private StringCalcService stringCalcService;

    @Before
    public void init() {
        stringCalcService = new StringCalcService();
    }

    @Test
    public void shouldSumDigitsInGivenString () {

        //ginen
        String value = "5;3";

        //when
        int expectedValue = 8;
        int actualValue = stringCalcService.calc(value);

        //then
        Assert.assertEquals("Results are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldSumNumbersInGivenString () {

        //ginen
        String value = "15;13";

        //when
        int expectedValue = 28;
        int actualValue = stringCalcService.calc(value);

        //then
        Assert.assertEquals("Results are not the same!", expectedValue, actualValue);
    }

    @Test
    public void shouldSumManyNumbersInGivenString () {

        //ginen
        String value = "22;32;2;6;8";

        //when
        int expectedValue = 70;
        int actualValue = stringCalcService.calc(value);

        //then
        Assert.assertEquals("Results are not the same!", expectedValue, actualValue);
    }

}
