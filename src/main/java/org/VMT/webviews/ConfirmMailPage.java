package org.VMT.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmMailPage {

    @FindBy(css = "div.ng-star-inserted")
    private WebElement signUpMessage;

    @FindBy(xpath = "//span[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    public WebElement getSignUpMessage() {
        return signUpMessage;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }
}
