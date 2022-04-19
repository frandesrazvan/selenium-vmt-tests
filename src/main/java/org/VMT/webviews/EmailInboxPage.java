package org.VMT.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailInboxPage {


    @FindBy(xpath = "//input[contains(@id, 'identifierId')]")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    private WebElement password;

    @FindBy(xpath = "//tbody/tr[1][contains(@class, 'zA zE')]")
    private WebElement mail;

    @FindBy(xpath = "//a[contains(text(), 'Reset password')]")
    private WebElement resetPasswordLink;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getMail() {
        return mail;
    }

    public WebElement getResetPasswordLink() {
        return resetPasswordLink;
    }
}
