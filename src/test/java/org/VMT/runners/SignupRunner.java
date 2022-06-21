package org.VMT.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber.html", "json:target/json-reports/reports.json"},
        glue = {"org.VMT"},
        features = {"src/test/resources/features/signup.feature"}
)
@RunWith(Cucumber.class)
public class SignupRunner {
}
