package com.qaworks.ola.steps;

import javax.inject.Inject;

import com.qaworks.ola.pages.ContactPage;
import com.qaworks.ola.pages.Homepage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
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
//        contactPage.submitUserMessage(); TODO

        try {

            Assert.assertTrue("Bug: Name is missing in contact form", !contactPage.nameRequiredErrorMessage.isDisplayed());
            Assert.assertTrue("Bug: Email is missing in contact form", !contactPage.emailRequiredErrorMessage.isDisplayed());
            Assert.assertTrue("Bug: Message is missing in contact form", !contactPage.messageRequiredErrorMessage.isDisplayed());

        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }


    }


//        @Then("^I should be able to contact QAWorks with the following information$")
//        public void i_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//        // E,K,V must be a scalar (String, Integer, Date, enum etc)
//        throw new PendingException();
//    }

    @When("^I enter no information and submit form$")
    public void i_enter_no_informationd_and_submit_form() throws Throwable {
 ContactPage contactPage = new ContactPage(webDriver);
 contactPage.submitUserMessage();
    }


    @When("^I enter only some details$")
    public void i_enter_only_some_details(Map<String, String > formDetails) throws Throwable {
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
        Assert.assertTrue("Bug: Name error message is missing in contact form", contactPage.nameRequiredErrorMessage.isDisplayed());
        Assert.assertTrue("Bug: Email error message is missing in contact form", contactPage.emailRequiredErrorMessage.isDisplayed());
        Assert.assertTrue("Bug: Message error text is missing in contact form", contactPage.messageRequiredErrorMessage.isDisplayed());

    }



    @Then("^I should get a message related to the missing information$")
    public void i_should_get_a_message_related_to_the_missing_information(Map<String, String> formDetails) throws Throwable {
        this.formDetails = formDetails;
        ContactPage contactPage = new ContactPage(webDriver);
        if (formDetails.get("name").isEmpty()){
            Assert.assertTrue("Bug: Missing name error message is not displayed.", contactPage.nameRequiredErrorMessage.isDisplayed());
        }

        if (formDetails.get("email").isEmpty()){
            Assert.assertTrue("Bug: Missing email error message is not displayed.", contactPage.emailRequiredErrorMessage.isDisplayed());
        }

        if (formDetails.get("message").isEmpty()){
            Assert.assertTrue("Bug: Missing user message error text is not displayed.", contactPage.messageRequiredErrorMessage.isDisplayed());
        }



    }



}