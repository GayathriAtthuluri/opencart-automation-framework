package com.opencart.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencart.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;

import com.opencart.base.BasePage;
import com.opencart.utilities.WaitUtility;

public class HomePage  extends BasePage{

	private static final Logger logger =
            LoggerUtility.getLogger();
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By myAccount = By.xpath("//a[contains(@class,'dropdown-toggle')]");
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Login");

    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector("#search button");

    // My Account
    public void clickMyAccount() {
    	 logger.info("Clicking My Account");
    	WaitUtility.waitForClickable(driver, myAccount).click();
       
    }

    // Register
    public void clickRegister() {
    	 logger.info("Clicking Register");
        driver.findElement(registerLink).click();
    }

    public void navigateToRegisterPage() {
    	logger.info("Navigating to Register page");
        clickMyAccount();
        clickRegister();
    }

    // Login
    public void clickLogin() {
    	logger.info("Clicking Login");
        driver.findElement(loginLink).click();
    }

    public void navigateToLoginPage() {
    	  logger.info("Navigating to Login page");
        clickMyAccount();
        clickLogin();
    }

    // Search
    public void enterProduct(String productName) {
    	 logger.info("Entering product in search box: " + productName);
    	 WaitUtility.waitForVisibility(driver, searchBox).sendKeys(productName);
    }

    public void clickSearch() {
    	 logger.info("Clicking Search button");
        driver.findElement(searchButton).click();
    }

    public void searchProduct(String productName) {
    	 logger.info("Searching for product: " + productName);
        enterProduct(productName);
        clickSearch();
    }

}


