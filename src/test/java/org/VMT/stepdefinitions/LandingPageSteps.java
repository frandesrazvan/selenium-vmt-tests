package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.VMT.TestBase;
import org.VMT.webviews.ConfirmMailPage;
import org.VMT.webviews.LandingPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LandingPageSteps extends TestBase {

    private LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    private ConfirmMailPage confirmMailPage = PageFactory.initElements(driver, ConfirmMailPage.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

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

    @And("^I type my email address in the email address input$")
    public void iTypeMyEmailAddress() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();

        String emailAddress = saltStr + "@gmail.com";

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
        js.executeScript("window.scrollBy(0,1000)");
        landingPage.getTermsAndConditions().click();
    }
    
    @And("^I press Enter$")
    public void iPressEnter() {
        landingPage.getFirstName().sendKeys(Keys.ENTER);
    }

    @Then("I am on the confirmation link page")
    public void iAmOnTheConfirmationLinkPage() {
        String confirmMailPageText = confirmMailPage.getSignUpMessage().getText();

        assertThat("Signup failed",
                confirmMailPageText,
                containsString("confirmation"));
    }

    @And("I click on Terms and Conditions link")
    public void iClickOnTermsAndConditionsLink() {
        js.executeScript("window.scrollBy(0,1000)");

        landingPage.getTermsAndConditionsLink().click();
    }

    @Then("The Terms and Conditions page opens in a separate tab")
    public void theTermsAndConditionsPageOpensInASeparateTab() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        String currentUrl = driver.getCurrentUrl();
        String expectedLink = "https://www.voicemailtel.com/voicemailtel-meeting-services-terms-of-service/";

        assertThat("You are were redirected on the wrong website",
                currentUrl,
                is(expectedLink));
    }

    @And("I click on Sign In then wait 2 seconds")
    public void iClickOnSignIn() throws InterruptedException {
        landingPage.getSignIn().click();
        TimeUnit.SECONDS.sleep(2);

    }
}
