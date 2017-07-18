package com.qaworks.ola.acceptancetests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        glue = {"com.qaworks.ola"},
        features = "src/test/resources/features",
        format = {"pretty", "json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/cucumber-pretty" },
        tags = {"@complete","~@ignore"}
)
public class RunCukesTest {
}