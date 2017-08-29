package com.sda.cucumber.writeservice;

import com.sda.service.StringCalcService;
import com.sda.service.WriteService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by RENT on 2017-08-29.
 */
public class WriteServiceSteps {

    private WriteService writeService;

    private String givenName;

    @Given("^I create new write service$")
    public void i_create_new_write_service() {
        writeService = new WriteService();
    }

    @When("^I pass example name$")
    public void i_pass_example_name() {
        givenName = "Szymon";
    }

    @When("^I pass example names$")
    public void i_pass_example_names() {
        givenName = "Bartek, Maria, Antek";
    }

    @Then("^result is correct$")
    public void result_is_correct() {
        Assert.assertEquals("Expected value should be different", "Hello, Szymon", writeService.action(givenName));
    }

    @Then("^result for multiple names is correct$")
    public void result_for_multiple_names_is_correct() {
        Assert.assertEquals("Expected value should be different", "Hello, Bartek, Maria and Antek", writeService.action(givenName));
    }

    @When("^I pass name (.*)$")
    public void i_pass_name_$name(String name) {
        givenName = name;
    }

    @Then("^result for defined name (.*) is correct$")
    public void result_for_defined_name_$name_is_correct(String name) {
        Assert.assertEquals("Expected value should be different", "Hello, " + name, writeService.action(givenName));
    }

    @Then("^result for name (.*) is (.*)$")
    public void result_for_name_$name_is_$expectedResult(String name, String expectedResult) {
        Assert.assertEquals("Expected value should be different", expectedResult, writeService.action(givenName));
    }
}
