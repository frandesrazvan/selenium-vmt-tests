package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.VMT.TestBase;
import org.VMT.webviews.ConfirmMailPage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConfirmMailSteps extends TestBase {

    private ConfirmMailPage confirmMailPage = PageFactory.initElements(driver, ConfirmMailPage.class);


    @And("I click the Sign in button")
    public void iClickTheSignInButton() {
        confirmMailPage.getSignInButton().click();
    }

    @Then("I am on the main page again")
    public void iAmOnTheMainPageAgain() {
        String currentUrl = driver.getCurrentUrl();
        String expectedLink = "https://meet.voicemailtel.com/signin";

        assertThat("Redirected to the wrong page",
                currentUrl,
                is(expectedLink));
    }
}
