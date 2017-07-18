package com.qaworks.ola.steps;

import javax.inject.Inject;

import com.qaworks.ola.pages.Contactpage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    @Inject
    private WebDriver webDriver;

//    private Contactpage contactpage = new Contactpage(webDriver);

    @Given("^I am on the QAWorks Site$")
    public void i_am_on_the_QAWorks_Site() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Contactpage contactpage = new Contactpage(webDriver);
        contactpage.gotoContactusPage(webDriver);

    }

    @Then("^I should be able to contact QAWorks with the following information$")
    public void i_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable values) throws Throwable {
        Contactpage contactpage = new Contactpage(webDriver);
        contactpage.nameField().sendKeys("Gadgets");
        contactpage.emailField().sendKeys("test@qaworks.com");
        contactpage.userMessageField().sendKeys("Not a new message");
        Thread.sleep(6000);
    }
}