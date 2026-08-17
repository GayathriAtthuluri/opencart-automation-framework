package com.opencart.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;
import com.opencart.utilities.LoggerUtility;
import com.opencart.utilities.WaitUtility;

public class LogoutPage extends BasePage {

    private static final Logger logger =
            LoggerUtility.getLogger();

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    private By myAccount = By.xpath("//span[text()='My Account']");
    private By logoutLink = By.linkText("Logout");
    private By logoutHeading = By.xpath("//div[@id='content']//h1");

    // Click My Account
    public void clickMyAccount() {

        logger.info("Clicking My Account");

        WaitUtility.waitForClickable(driver, myAccount).click();
    }

    // Click Logout
    public void clickLogout() {

        logger.info("Clicking Logout");

        WaitUtility.waitForClickable(driver, logoutLink).click();

        logger.info("Logout action completed");
    }

    // Navigate to Logout Page
    public void navigateToLogoutPage() {

        logger.info("Navigating to Logout page");

        clickMyAccount();
        clickLogout();
    }

    // Verify Logout Successful
    public boolean isLogoutSuccessful() {

        logger.info("Checking logout success");

        boolean success =
                WaitUtility.waitForVisibility(driver, logoutHeading)
                          .isDisplayed();

        logger.info("Logout successful: " + success);

        return success;
    }
}
