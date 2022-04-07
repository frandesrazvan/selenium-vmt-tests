package org.VMT.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    @FindBy(id = "mat-input-3")
    private WebElement firstName;

    @FindBy(id = "mat-input-4")
    private WebElement lastName;

    @FindBy(id = "mat-input-5")
    private WebElement emailAddress;

    @FindBy(id = "mat-input-6")
    private WebElement password;

    @FindBy(id = "mat-input-7")
    private WebElement confirmPassword;

    @FindBy(className = "mat-checkbox-inner-container")
    private WebElement termsAndConditions;

    @FindBy(linkText = "Terms and Conditions")
    private WebElement termsAndConditionsLink;

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getTermsAndConditions() {
        return termsAndConditions;
    }

    public WebElement getTermsAndConditionsLink() {
        return termsAndConditionsLink;
    }
}
