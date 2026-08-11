package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;

public class ProductPage extends BasePage {
	
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
	}

	
	
	
	private By productName = By.xpath("//div[@id='content']//h1");
	private By quantityTextBox=By.id("input-quantity");
	private By addToCartButton=By.xpath("//button[@id='button-cart']");
	
	
	// Verify ProductName
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	// Enter Quantity
	
	public void enterQuantity(String quantity)
	{
		driver.findElement(quantityTextBox).clear();
		driver.findElement(addToCartButton).sendKeys(quantity );
	}
	
	public void clickAddtoCart()
	{
		driver.findElement(addToCartButton).click();
	}
	
	
	
}



