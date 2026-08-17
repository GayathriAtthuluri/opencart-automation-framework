package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.Logger;
import com.opencart.utilities.LoggerUtility;
import com.opencart.utilities.WaitUtility;
import com.opencart.base.BasePage;

public class ProductPage extends BasePage {
	 private static final Logger logger =
	            LoggerUtility.getLogger();
	
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
		logger.info("Getting product name");

        String name = WaitUtility.waitForVisibility(driver, productName)
                .getText();

        logger.info("Product name: " + name);

        return name;
	}
	
	// Enter Quantity
	
	public void enterQuantity(String quantity)
	{
		 logger.info("Entering product quantity: " + quantity);

	        WaitUtility.waitForVisibility(driver, quantityTextBox).clear();

	        WaitUtility.waitForVisibility(driver, quantityTextBox)
	                .sendKeys(quantity);
	}
	
	public void clickAddtoCart()
	{
		logger.info("Clicking Add to Cart button");

        WaitUtility.waitForClickable(driver, addToCartButton).click();

        logger.info("Product added to cart successfully");
	}
	
	
	
}



