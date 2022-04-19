package org.VMT.stepdefinitions;

import io.cucumber.java.en.And;

import java.util.concurrent.TimeUnit;

public class WaitSteps {

    @And("I wait {string}")
    public void iWait(String seconds) throws InterruptedException {
        int sec = Integer.parseInt(seconds);

        TimeUnit.SECONDS.sleep(sec);
    }
}
