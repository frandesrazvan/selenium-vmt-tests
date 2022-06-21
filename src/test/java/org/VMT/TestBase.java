package org.VMT;

import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver = DriverFactory.getDriver();

    public void openLandingPage() {
        driver.get(AppConfig.getSiteUrl());
    }

}
