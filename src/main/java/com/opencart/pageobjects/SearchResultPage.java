package com.opencart.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;
import com.opencart.utilities.LoggerUtility;
import com.opencart.utilities.WaitUtility;

public class SearchResultPage extends BasePage {

    private static final Logger logger =
            LoggerUtility.getLogger();

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    // Locator
    private By product = By.linkText("MacBook");

    // Verify Product is Displayed
    public boolean isProductDisplayed() {

        logger.info("Checking whether MacBook product is displayed");

        boolean displayed =
                WaitUtility.waitForVisibility(driver, product)
                           .isDisplayed();

        logger.info("MacBook product displayed: " + displayed);

        return displayed;
    }

    // Click Product
    public void clickProduct() {

        logger.info("Clicking MacBook product");

        WaitUtility.waitForClickable(driver, product).click();

        logger.info("MacBook product clicked successfully");
    }
}