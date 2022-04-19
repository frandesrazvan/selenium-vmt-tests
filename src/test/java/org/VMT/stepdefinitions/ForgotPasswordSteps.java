package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.VMT.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.VMT.webviews.ForgotPasswordPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ForgotPasswordSteps extends TestBase {

    private ForgotPasswordPage forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);

    @And("I fill my {string}")
    public void iFillMyEmailAddress(String email) {
        forgotPasswordPage.getEmailAddress().sendKeys(email);
    }

    @And("I click the Continue button")
    public void iClickTheContinueButton() {
        forgotPasswordPage.getContinueButton().click();
    }

    @Then("I see a pop-up saying Success")
    public void iSeeAPopUpSayingSuccess() {
        String popupMessageTitle = forgotPasswordPage.getSuccessPopup().getText();

        assertThat("Popup message incorrect",
                popupMessageTitle,
                containsString("SUCCESS"));
    }
}
