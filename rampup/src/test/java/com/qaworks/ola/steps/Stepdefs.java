package com.qaworks.ola.steps;

import javax.inject.Inject;

import com.qaworks.ola.pages.ContactPage;
import com.qaworks.ola.pages.Homepage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    @Inject
    private WebDriver webDriver;

    private Map<String, String> formDetails;

    @Given("^I am on the QAWorks Site$")
    public void i_am_on_the_QAWorks_Site() throws Throwable {
        Homepage homepage = new Homepage(webDriver);
        homepage.gotoHomepage(webDriver);
    }

    @Given("^I am on the QAWorks contacts page$")
    public void i_am_on_the_QAWorks_contacts_page() throws Throwable {
        ContactPage contactPage = new ContactPage(webDriver);
        contactPage.gotoContactusPage(webDriver);
    }

    @Then("^I should be able to contact QAWorks with the following information$")
    public void i_should_be_able_to_contact_QAWorks_with_the_following_information(Map<String, String> formDetails) throws Throwable {
        this.formDetails = formDetails;
        ContactPage contactPage = new ContactPage(webDriver);
        contactPage.fillContactsForm(formDetails.get("name"),
                formDetails.get("email"),
                formDetails.get("message"));
        contactPage.submitUserMessage();

        try {

            Assert.assertTrue("Bug: Name is missing in contact form", !contactPage.nameRequiredErrorMessage.isDisplayed());
            Assert.assertTrue("Bug: Email is missing in contact form", !contactPage.emailRequiredErrorMessage.isDisplayed());
            Assert.assertTrue("Bug: Message is missing in contact form", !contactPage.messageRequiredErrorMessage.isDisplayed());

        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }


    }







}