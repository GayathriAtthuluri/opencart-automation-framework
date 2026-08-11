package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;

public class SearchResultPage extends BasePage{

   
    // Constructor
    public SearchResultPage(WebDriver driver) {
    	super(driver);
    }

    // Locator
    private By product = By.linkText("MacBook");

    // Verify Product is Displayed
    public boolean isProductDisplayed() {
        return driver.findElement(product).isDisplayed();
    }

    // Click Product
    public void clickProduct() {
        driver.findElement(product).click();
    }

}


