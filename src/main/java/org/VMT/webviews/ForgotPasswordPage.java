package org.VMT.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

    @FindBy(id = "mat-input-16")
    private WebElement emailAddress;

    @FindBy(xpath = "//button[contains(@tabindex, '7')]")
    private WebElement continueButton;

    @FindBy(css = "div.alert-success-title")
    private WebElement successPopup;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getSuccessPopup() {
        return successPopup;
    }
}
