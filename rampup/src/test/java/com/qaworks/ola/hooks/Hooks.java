package com.qaworks.ola.hooks;

import javax.inject.Inject;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class Hooks {

    private final WebDriver driver;

    @Inject
    public Hooks(final WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void openWebSite() {
//        Map<String, Object> chromeOptions = new Map<String,Object>();
//        chromeOptions.put("binary", "/usr/lib/chromium-browser/chromium-browser");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        WebDriver driver = new ChromeDriver(capabilities);
        driver.navigate().to("http://www.qaworks.com");
    }

    @After
    public void closeSession() {
        driver.close();
    }
}
