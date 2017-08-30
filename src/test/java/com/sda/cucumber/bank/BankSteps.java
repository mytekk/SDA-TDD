package com.sda.cucumber.bank;

import com.sda.bank.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * Created by RENT on 2017-08-30.
 */
public class BankSteps {

    private Bank bank;
    private User user;
    private Account account;

    @Given("^I create new bank$")
    public void i_create_new_bank() {
        this.bank = new Bank("SDA");
    }

    @When("^I create new user$")
    public void i_create_new_user() {
        this.user = UserFactory.createNewUser("Bartek", "Mytko");
    }

    @And("^I add new user to bank$")
    public void i_add_new_user_to_bank() {
        bank.addUser(user);
    }

    @Then("^User is present in bank database$")
    public void user_is_present_in_bank_database() {
        boolean result = this.bank.getUsers().contains(user);

        Assert.assertTrue("User is not present in bank database", result);
    }

    @And("^I create new account$")
    public void i_create_new_account() {
        this.account = AccountFactory.createAccount();
    }

    @And("^Account is present in bank database$")
    public void account_is_present_in_bank_database() {
        boolean result = this.bank.getAccounts().contains(account);

        Assert.assertTrue("Account is not presented in bank database", result);
    }

    @And("^User is attached to account in bank database$")
    public void user_is_attached_to_account_in_bank_database() {
        //boolean result = account.getOwnerId().equals(user.getId());

        //pobieram acounta zdefiniowanego w tej klasie i sprawdzam czy jego owner jest taki sam jak user z tej klasy
        Account accountFromDatabase = bank.getAccount(this.account.getId());
        User userfromDatabase = bank.getUser(this.user.getId());

        Assert.assertTrue("User is not attached to account", accountFromDatabase.getOwnerId().equals(userfromDatabase.getId()));
    }

    @And("^I add user to account$")
    public void i_add_user_to_account() {
        this.account.setOwnerId(user.getId());
    }

    @And("^I add account to bank$")
    public void i_add_account_to_bank() {
        bank.addAccount(account);
    }

    //wykona sie po kazdym scenariuszu
    @After
    public void clearFactories() {
        UserFactory.clearIndex();
        AccountFactory.clearIndex();
    }

    ///////////////////////////////////////////

    @When("^I create new user with firstName (.*) and lastName (.*) and add it to bank$")
    public void i_create_new_user_with_$firstName_and_$lastName_and_add_it_to_bank(String firstName, String lastName) {
        this.user = UserFactory.createNewUser(firstName, lastName);
        i_add_new_user_to_bank();
    }

    @And("^I create new account for user (.*) and add it to bank$")
    public void i_create_new_account_for_user_$user_and_add_it_to_bank(Integer id) {
        this.account = AccountFactory.createAccount(id);
        i_add_account_to_bank();
    }

    @Then("^User with id (.*) is present in bank database$")
    public void user_with_id_0_is_present_in_bank_database(Integer id) {
        boolean result = bank.getUser(id) != null;

        Assert.assertTrue("User with id  " + id + " is not present in database", result);
    }

    @And("^User with id (.*) has (.*) accounts$")
    public void user_with_id_$id_has_$accounts_accounts(Integer id, Integer expectedResult) {
        List<Account> accountsByUser = bank.getAccountsByUser(id);

        Assert.assertEquals("User should have " + expectedResult + " accounts",
                expectedResult,
                Integer.valueOf(accountsByUser.size()));
    }

}