package com.opencart.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;
import com.opencart.utilities.LoggerUtility;
import com.opencart.utilities.WaitUtility;

public class RegistrationSuccessPage extends BasePage {

    private static final Logger logger =
            LoggerUtility.getLogger();

    public RegistrationSuccessPage(WebDriver driver) {
        super(driver);
    }

    private By successHeading =
            By.xpath("//h1[contains(text(),'Your Account Has Been Created')]");

    public boolean isRegistrationSuccessful() {

        logger.info("Checking registration success message");

        boolean displayed = WaitUtility
                .waitForVisibility(driver, successHeading)
                .isDisplayed();

        logger.info("Registration successful: " + displayed);

        return displayed;
    }
}