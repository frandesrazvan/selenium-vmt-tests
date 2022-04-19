package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.VMT.TestBase;
import org.VMT.webviews.SignInPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SignInPageSteps extends TestBase {

    private SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

    @And("I type an incorrect {string} in the email address input then i press enter")
    public void iTypeAnIncorrectInTheEmailAddressInputThenIPressEnter(String emailAddress) {
        signInPage.getEmailAddress().sendKeys(emailAddress + Keys.ENTER);
    }

    @And("I wait 1 second")
    public void iWaitSecond() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    @Then("I should see the message: Email pattern is invalid")
    public void iShouldSeeTheMessageEmailPatternIsInvalid() {
        assertThat("Wrong email address pattern is accepted",
                signInPage.getEmailAddressErrorMessage().getText(),
                is("invalid"));
    }

    @And("I click on forgot password")
    public void iClickOnForgotPassword() {
        signInPage.getForgotPassword().click();
    }
}
