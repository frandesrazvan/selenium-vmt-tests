package org.VMT.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmMailPage {

    @FindBy(css = "div.ng-star-inserted")
    private WebElement signUpButton;

    public WebElement getSignUpButton() {
        return signUpButton;
    }
}
