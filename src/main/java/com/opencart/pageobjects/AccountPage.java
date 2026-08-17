package com.opencart.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;
import com.opencart.utilities.LoggerUtility;
import com.opencart.utilities.WaitUtility;

public class AccountPage extends BasePage {

    private static final Logger logger =
            LoggerUtility.getLogger();

    // Constructor
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    // Locator
    private By editAccountInformation =
            By.linkText("Edit your account information");

    // Verify My Account Page
    public boolean isMyAccountPageDisplayed() {

        logger.info("Checking My Account page");

        boolean displayed =
                WaitUtility.waitForVisibility(
                        driver, editAccountInformation)
                        .isDisplayed();

        logger.info("My Account page displayed: " + displayed);

        return displayed;
    }
}