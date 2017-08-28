package com.sda.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by RENT on 2017-08-28.
 */
public class MyStringUtilsTest {

    @Test
    public void shouldReturnTrueForValueWithCapitalCases() {
        String givenValue = "ALA MA KOTA";

        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertTrue("Expected value contains lower cases", result);
    }

    @Test
    public void shouldReturnFalseForValueWithLowerCases() {
        String givenValue = "ala ma kota";

        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertFalse("Expected value contains lower cases", result);
    }

    @Test
    public void shouldReturnFalseForMixCaseValue() {
        String givenValue = "AlA ma KoTa";

        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertFalse("Expected value contains lower cases", result);
    }

    @Test
    public void shouldReturnFalseForNullValue() {
        String givenValue = null;

        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertFalse("Expected value contains lower cases", result);
    }

}
