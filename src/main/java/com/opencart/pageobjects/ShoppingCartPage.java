package com.opencart.pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.base.BasePage;
import com.opencart.utilities.LoggerUtility;
import com.opencart.utilities.WaitUtility;

public class ShoppingCartPage extends BasePage{
	private static final Logger logger =
            LoggerUtility.getLogger();
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By shoppingCartLink = By.linkText("Shopping Cart");
	private By productName = By.linkText("MacBook");
	private By quantityTextBox=By.cssSelector("input[name='quantity']");
	private By removeButton=By.cssSelector("button[data-original-title='Remove']");
	private By emptyCartMessage =
	        By.xpath("//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]");
	
	
	 // Click Shopping Cart link
    public void clickShoppingCart() {
    	 logger.info("Clicking Shopping Cart");

         driver.findElement(shoppingCartLink).click();

         logger.info("Shopping Cart page opened");
        
    }

	    // Verify Product
	    public boolean isProductAdded(String product) {
	    	logger.info("Checking whether " + product + " is added to cart");

	        boolean displayed = driver.findElement(productName).isDisplayed();

	        logger.info("Product displayed in cart: " + displayed);

	        return displayed;
	    }
	 
	 //  	Get Quantity 
	 
	 public String getQuantity() {
		 logger.info("Getting product quantity");

	        String quantity = driver.findElement(quantityTextBox)
	                .getAttribute("value");

	        logger.info("Product quantity: " + quantity);

	        return quantity;
	 }
	 
	 // Remove Product
	 
	 public void removeProduct()
	 {
		 logger.info("Removing product from cart");

	        // Keep the existing working wait
	        WaitUtility.waitForClickable(driver, removeButton).click();

	        logger.info("Product removed from cart");
	 }
	 
	 // Empty message is Displayed
	 
	 public boolean isCartEmpty() {
		 logger.info("Checking whether cart is empty");

	        WaitUtility.waitForVisibility(driver, emptyCartMessage);

	        boolean empty = driver.findElement(emptyCartMessage).isDisplayed();

	        logger.info("Cart empty: " + empty);

	        return empty;
		}

}
