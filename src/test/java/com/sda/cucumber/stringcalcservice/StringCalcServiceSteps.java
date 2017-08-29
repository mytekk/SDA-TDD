package com.sda.cucumber.stringcalcservice;

import com.sda.service.StringCalcService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by RENT on 2017-08-29.
 */
public class StringCalcServiceSteps {

    private StringCalcService stringCalcService;

    private String givenString;

    private int expectedValue;

    @Given("^I create new string calc service$")
    public void i_create_new_string_calc_service() {
        stringCalcService = new StringCalcService();
    }

    @When("^I pass example string with (.*) digits$")
    public void i_pass_example_string_with_$tmpString_digits(String tmpString) {
        givenString = tmpString;
    }

    @And("^i pass (.*) result for example string with digits$")
    public void i_pass_$result_result_for_example_string_with_digits(String result) {
        expectedValue = Integer.valueOf(result);
    }

    @Then("^result is correct$")
    public void result_is_correct() {
        Assert.assertEquals("Expected result is wrong", expectedValue, stringCalcService.calc(givenString));
    }

}
