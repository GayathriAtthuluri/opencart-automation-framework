package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;

public class LoginPage extends BasePage {

	
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
    	driver.findElement(emailTextBox).sendKeys(email);
    }
    
    public void enterPassword(String password)
    {
    	driver.findElement(passwordTextBox).sendKeys(password);
    }
    
    public void clickLogin()
    {
    	driver.findElement(loginButton).click();
    }
    
    
    public void login(String email, String password)
    {
    	enterEmail(email);
    	enterPassword(password);
    	clickLogin();
    	
    }
	
	
	
	
	
	
	
	
}

