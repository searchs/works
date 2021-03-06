package com.qaworks.ola.steps;

import javax.inject.Inject;

import com.qaworks.ola.pages.ContactMessage;
import com.qaworks.ola.pages.ContactPage;
import com.qaworks.ola.pages.Homepage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    @Inject
    private WebDriver webDriver;

    private Map<String, String> formDetails;
    private List<ContactMessage> contactDetails;

    private WebDriverWait fWait = null;

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


    @When("^I enter no information and submit form$")
    public void i_enter_no_informationd_and_submit_form() throws Throwable {
        ContactPage contactPage = new ContactPage(webDriver);
        contactPage.submitUserMessage();
    }


    @When("^I enter only some details$")
    public void i_enter_only_some_details(Map<String, String> formDetails) throws Throwable {
        this.formDetails = formDetails;
        ContactPage contactPage = new ContactPage(webDriver);
        contactPage.fillContactsForm(formDetails.get("name"),
                formDetails.get("email"),
                formDetails.get("message"));
        contactPage.submitUserMessage();
    }


    @Then("^I should get messages relating to all the missing information$")
    public void i_should_get_messages_relating_to_all_the_missing_information() throws Throwable {
        ContactPage contactPage = new ContactPage(webDriver);
        fWait = new WebDriverWait(webDriver,10);
        Assert.assertTrue("Bug: Name error message is missing in contact form", contactPage.nameRequiredErrorMessage.isDisplayed());
        Assert.assertTrue("Bug: Email error message is missing in contact form", contactPage.emailRequiredErrorMessage.isDisplayed());
        Assert.assertTrue("Bug: Message error text is missing in contact form", contactPage.messageRequiredErrorMessage.isDisplayed());

    }


    @Then("^I should get a message related to the missing information$")
    public void i_should_get_a_message_related_to_the_missing_information(Map<String, String> formDetails) throws Throwable {
        this.formDetails = formDetails;
        fWait = new WebDriverWait(webDriver,10);
        ContactPage contactPage = new ContactPage(webDriver);
        if (formDetails.get("name").isEmpty()) {
            Assert.assertTrue("Bug: Missing name error message is not displayed.", contactPage.nameRequiredErrorMessage.isDisplayed());
        }

        if (formDetails.get("email").isEmpty()) {
            Assert.assertTrue("Bug: Missing email error message is not displayed.", contactPage.emailRequiredErrorMessage.isDisplayed());
        }

        if (formDetails.get("message").isEmpty()) {
            Assert.assertTrue("Bug: Missing user message error text is not displayed.", contactPage.messageRequiredErrorMessage.isDisplayed());
        }

        Assert.assertTrue("BUG: Web app has crashed! Displaying exceptions to the world. ",!webDriver.getPageSource().contains("HttpRequestValidationException"));

    }

    @Then("^I should get invalid email address error message$")
    public void i_should_get_invalid_email_address_error_message() throws Throwable {
        ContactPage contactPage = new ContactPage(webDriver);
        Assert.assertTrue("Bug:  Invalid email address is being accepted as OK.", contactPage.invalidEmailMessage.isDisplayed());
        Assert.assertEquals("invalid email address", contactPage.invalidEmailMessage.getText().toLowerCase());
    }
//BUG Found(Firefox 54.0/64bit on Linux Mint 18):  Stack Trace displayed when email supplied is just domain name

}