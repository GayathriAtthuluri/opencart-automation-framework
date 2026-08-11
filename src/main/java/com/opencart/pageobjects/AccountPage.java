package com.opencart.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.base.BasePage;
import com.opencart.utilities.WaitUtility;

public class AccountPage extends BasePage{


    // Constructor
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    // Locator
    private By editAccountInformation = By.linkText("Edit your account information");

    // Verify My Account Page
    public boolean isMyAccountPageDisplayed() {

        WaitUtility.waitForVisibility(driver,editAccountInformation);

        return driver.findElement(editAccountInformation).isDisplayed();
    }

}
