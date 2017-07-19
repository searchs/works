package com.qaworks.ola.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class Hooks {

    private final WebDriver driver;

    @Inject
    public Hooks(final WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void openWebSite() {

        driver.navigate().to("http://www.qaworks.com");
    }

    @After
    public void closeSession() {
        driver.close();
    }
}
