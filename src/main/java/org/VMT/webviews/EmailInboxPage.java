package org.VMT.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailInboxPage {


    @FindBy(xpath = "//input[contains(@id, 'identifierId')]")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    private WebElement password;

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div[2]/div/table/tbody/tr[1]/td[5]/div/div/div")
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
