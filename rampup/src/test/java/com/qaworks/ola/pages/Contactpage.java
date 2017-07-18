package com.qaworks.ola.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by oladevs on 17/07/17.
 */
public class Contactpage {


    public Contactpage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    WebDriver driver;
    By username = By.id("ctl00_MainContent_NameBox");
    By userEmail = By.id("ctl00_MainContent_EmailBox");
    By userMessage = By.id("ctl00_MainContent_MessageBox");
    By sendMessageButton = By.id("ctl00_MainContent_SendButton");

    @FindBy(how = How.ID,using = "ctl00_MainContent_NameBox")
    private WebElement usernameField;

    @FindBy(how = How.ID,using = "ctl00_MainContent_EmailBox")
    private WebElement userEmaileField;

    @FindBy(how = How.ID,using = "ctl00_MainContent_MessageBox")
    private WebElement userMessageTextField;

    @FindBy(how = How.ID,using = "ctl00_MainContent_SendButton")
    private WebElement sendMessageButtonNew;

    public void filContactlForm(String userFullName, String userEmail, String userMessages){

    }

    public void gotoContactusPage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to("http://qaworks.com/contact.aspx");
    }






}
