package com.qaworks.ola.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ContactPage {

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;

    @FindBy(how = How.ID, using = "ctl00_MainContent_NameBox")
    public WebElement userNameField;


    @FindBy(how = How.ID, using = "ctl00_MainContent_EmailBox")
    public WebElement userEmailField;

    @FindBy(how = How.ID, using = "ctl00_MainContent_MessageBox")
    public WebElement userMessageField;

    @FindBy(how = How.ID, using = "ctl00_MainContent_SendButton")
    public WebElement sendMessageButton;


    @FindBy(how = How.ID, using = "ctl00_MainContent_rfvName")
    public WebElement nameRequiredErrorMessage;

    @FindBy(how = How.ID, using = "ctl00_MainContent_rfvEmailAddress")
    public WebElement emailRequiredErrorMessage;

    @FindBy(how = How.ID, using = "ctl00_MainContent_rfvMessage")
    public WebElement messageRequiredErrorMessage;

    public void fillContactsForm(String fullname, String emailAddress, String messageText) {
        userNameField.sendKeys(fullname);
        userEmailField.sendKeys(emailAddress);
        userMessageField.sendKeys(messageText);

    }

    public void submitUserMessage() {
        sendMessageButton.submit();
    }

    public void gotoContactusPage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to("http://qaworks.com/contact.aspx");
    }


}
