package com.opencart.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.opencart.driver.DriverFactory;
import com.opencart.utilities.ConfigReader;
import com.opencart.utilities.LoggerUtility;

public class BaseTest {
	
	protected WebDriver driver;
	private static final Logger logger =
	        LoggerUtility.getLogger();
	
	@BeforeMethod
	public void setup() {

	    logger.info("Starting browser setup");

	    driver = DriverFactory.getDriver();

	    logger.info("Browser launched successfully");

	    driver.get(ConfigReader.getProperty("url"));

	    logger.info("Navigated to OpenCart application");
	}
	@AfterMethod
	public void teardown() {

	    logger.info("Closing browser");

	    DriverFactory.quitDriver();

	    logger.info("Browser closed successfully");
	}
	
	
	public WebDriver getDriver()
	{
		return driver;
	}
}
