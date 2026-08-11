package com.opencart.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.base.BasePage;
import com.opencart.utilities.WaitUtility;

public class HomePage  extends BasePage{

    
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
    	WaitUtility.waitForClickable(driver, myAccount).click();
       
    }

    // Register
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void navigateToRegisterPage() {
        clickMyAccount();
        clickRegister();
    }

    // Login
    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void navigateToLoginPage() {
        clickMyAccount();
        clickLogin();
    }

    // Search
    public void enterProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public void searchProduct(String productName) {
        enterProduct(productName);
        clickSearch();
    }

}


