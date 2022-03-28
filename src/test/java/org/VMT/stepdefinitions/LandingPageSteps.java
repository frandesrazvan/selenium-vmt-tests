package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.VMT.TestBase;
import org.VMT.webviews.ConfirmMailPage;
import org.VMT.webviews.LandingPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LandingPageSteps extends TestBase {

    private LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    private ConfirmMailPage confirmMailPage = PageFactory.initElements(driver, ConfirmMailPage.class);
    
    @Given("^I open the landing page$")
    public void iOpenTheLandingPage() {
        openLandingPage();
    }

    @And("^I type my \"(.+)\" in the first name input$")
    public void iTypeMyFirstName(String firstName) {
        landingPage.getFirstName().sendKeys(firstName);
    }

    @And("^I type my \"(.+)\" in the last name input$")
    public void iTypeMyLastName(String lastName) {
        landingPage.getLastName().sendKeys(lastName);
    }

    @And("^I type my \"(.+)\" in the email address input$")
    public void iTypeMyEmailAddress(String emailAddress) {
        landingPage.getEmailAddress().sendKeys(emailAddress);
    }

    @And("^I type my \"(.+)\" in the password input$")
    public void iTypeMyPassword(String password) {
        landingPage.getPassword().sendKeys(password);
    }

    @And("^I type my \"(.+)\" again in the confirm password input$")
    public void iTypeMyConfirmPassword(String confirmPassword) {
        landingPage.getConfirmPassword().sendKeys(confirmPassword);
    }

    @When("^I accept terms and conditions$")
    public void iAcceptTermsAndConditions() {
        landingPage.getTermsAndConditions().click();
    }
    
    @And("^I press Enter$")
    public void iPressEnter() {
        landingPage.getFirstName().sendKeys(Keys.ENTER);
    }

    @And("I wait 5 seconds")
    public void iWaitSeconds() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    @Then("I am on the confirmation link page")
    public void iAmOnTheConfirmationLinkPage() {
        String confirmMailPageText = confirmMailPage.getSignUpButton().getText();

        assertThat("Signup failed",
                confirmMailPageText,
                containsString("confirmation"));
    }
}
