package com.opencart.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.base.BasePage;
import com.opencart.utilities.WaitUtility;

public class RegistrationSuccessPage extends BasePage{


    // Constructor
    public RegistrationSuccessPage(WebDriver driver) {
    	super(driver);
    }

    // Locator
    private By successHeading =
            By.xpath("//h1[contains(text(),'Your Account Has Been Created')]");

    // Verify Registration Success
    public boolean isRegistrationSuccessful() {

       WaitUtility.waitForVisibility(driver, successHeading);

        return driver.findElement(successHeading).isDisplayed();
    }

}
