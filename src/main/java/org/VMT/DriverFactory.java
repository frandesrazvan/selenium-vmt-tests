package org.VMT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver(String browser) {

        WebDriver driver;

        switch (browser) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());

                driver = new ChromeDriver();

                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", AppConfig.getGeckoDriverPath());

                driver = new FirefoxDriver();

                break;

            case "safari":
                System.setProperty("webdriver.safari.driver", AppConfig.getSafariDriverPath());

                driver = new SafariDriver();

                break;

            default:
                System.out.println("Wrong input, using default browser: Chrome.");

                System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());

                driver = new ChromeDriver();

                break;
        }

        driver.manage().window().maximize();

        DriverFactory.driver = driver;

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
