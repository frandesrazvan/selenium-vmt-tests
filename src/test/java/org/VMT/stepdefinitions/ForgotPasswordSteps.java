package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.VMT.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.VMT.webviews.ForgotPasswordPage;

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

    @And("I type a unregistered valid {string} then press Enter")
    public void iTypeAUnregisteredValid(String emailAddress) {
        forgotPasswordPage.getEmailAddress().sendKeys(emailAddress + Keys.ENTER);
    }

    @Then("I see an error message")
    public void iSeeAnErrorMessage() {
        String expectedMessage = "The email address you entered is not associated with an account. Please enter the e-mail address associated with your account or Sign up to create your account";

        assertThat("Displayed error message is not the expected one",
                forgotPasswordPage.getEmailErrorMessage().getText(),
                is(expectedMessage));
    }
}
