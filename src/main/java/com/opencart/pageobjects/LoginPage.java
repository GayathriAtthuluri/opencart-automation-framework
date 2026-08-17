package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;
import org.apache.logging.log4j.Logger;
import com.opencart.utilities.LoggerUtility;

public class LoginPage extends BasePage {

	 private static final Logger logger =
	            LoggerUtility.getLogger();
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	// locators
	
	private By emailTextBox= By.id("input-email");
	private By passwordTextBox=By.id("input-password");
    private By loginButton = By.cssSelector("input[value='Login']");
    
    //method
    
    public void enterEmail(String email)
    {
    	logger.info("Entering email");
    	driver.findElement(emailTextBox).sendKeys(email);
    }
    
    public void enterPassword(String password)
    {
    	 logger.info("Entering password");
    	driver.findElement(passwordTextBox).sendKeys(password);
    }
    
    public void clickLogin()
    {
    	 logger.info("Clicking Login button");
    	driver.findElement(loginButton).click();
    }
    
    
    public void login(String email, String password)
    {
    	 logger.info("Starting login");
    	enterEmail(email);
    	enterPassword(password);
    	clickLogin();
    	logger.info("Login action completed");
    	
    }
	
	
	
	
	
	
	
	
}

