package com.opencart.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.base.BasePage;
import com.opencart.utilities.WaitUtility;

public class ShoppingCartPage extends BasePage{
	
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
        driver.findElement(shoppingCartLink).click();
    }

	    // Verify Product
	    public boolean isProductAdded(String product) {
	        return driver.findElement(productName).isDisplayed();
	    }
	 
	 //  	Get Quantity 
	 
	 public String getQuantity() {
		 return driver.findElement(quantityTextBox).getAttribute("value");
	 }
	 
	 // Remove Product
	 
	 public void removeProduct()
	 {
		 WaitUtility.waitForClickable(driver,removeButton).click();
	 }
	 
	 // Empty message is Displayed
	 
	 public boolean isCartEmpty() {
		 WaitUtility.waitForVisibility(driver,emptyCartMessage);

		    return driver.findElement(emptyCartMessage).isDisplayed();
		}

}
