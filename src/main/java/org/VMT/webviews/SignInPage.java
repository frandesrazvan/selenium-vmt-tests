package org.VMT.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy(xpath = "//input[contains(@formcontrolname, 'email') and contains(@data-placeholder, 'Email address')]")
    private WebElement emailAddress;

    @FindBy(xpath = "//strong[contains(text(), 'invalid')]")
    private WebElement emailAddressErrorMessage;

    @FindBy(xpath = "//a[contains(@tabindex, '8')]")
    private WebElement forgotPassword;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getEmailAddressErrorMessage() {
        return emailAddressErrorMessage;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }
}
