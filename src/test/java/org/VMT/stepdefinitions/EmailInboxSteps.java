package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.VMT.TestBase;
import org.VMT.webviews.EmailInboxPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EmailInboxSteps extends TestBase {

    private EmailInboxPage emailInboxPage = PageFactory.initElements(driver, EmailInboxPage.class);

    @Then("I go to my email")
    public void iGoToMyEmail() {
        String emailInboxUrl = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(emailInboxUrl);
    }

    @And("I type my {string} then press Enter")
    public void iTypeMyEmailAddress(String email) {
        emailInboxPage.getEmailAddress().sendKeys(email + Keys.ENTER);
    }

    @And("I type my password then press Enter")
    public void iTypeMyPasswordThenPressEnter() {
        String password = "Passwd123!";

        emailInboxPage.getPassword().sendKeys(password + Keys.ENTER);
    }

    @Then("I click on the mail")
    public void iClickOnTheMail() {
        emailInboxPage.getMail().click();
    }

    @And("I click on Reset password link")
    public void iClickOnResetPasswordLink() {
        emailInboxPage.getResetPasswordLink().click();
    }

    @Then("I should be on the reset password page")
    public void iShouldBeOnTheResetPasswordPage() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(2));
        String currentUrl = driver.getCurrentUrl();

        assertThat("Reset password link from the mail redirected to the wrong page",
                currentUrl,
                containsString("reset-password"));
    }
}
