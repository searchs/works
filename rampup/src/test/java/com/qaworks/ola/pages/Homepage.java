package com.qaworks.ola.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;


    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void gotoHomepage(WebDriver driver){
        this.driver = driver;
        driver.navigate().to("http://www.qaworks.com");
    }

}
