package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;

public class LogoutPage extends BasePage{
	
	
	
	public LogoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By myAccount = By.xpath("//span[text()='My Account']");
    private By logoutLink = By.linkText("Logout");
    private By logoutHeading = By.xpath("//div[@id='content']//h1");
    
    
    // Click My Account
    public void clickMyAccount()
    {
    	driver.findElement(myAccount).click();
    }
    
    public void clickLogout()
    {
    	driver.findElement(logoutLink).click();
    }
    
    // Navigate to Logout Page
    
    public void navigateToLogoutPage()
    {
    	clickMyAccount();
    	clickLogout();
    }
    
 // Verify Logout Successful
    public boolean isLogoutSuccessful() {
        return driver.findElement(logoutHeading).isDisplayed();
    }

    
    
}
