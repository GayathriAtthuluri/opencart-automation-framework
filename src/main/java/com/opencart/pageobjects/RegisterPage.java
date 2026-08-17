package com.opencart.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;
import com.opencart.utilities.LoggerUtility;

public class RegisterPage extends BasePage {

    private static final Logger logger =
            LoggerUtility.getLogger();

    // Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacyPolicy = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");

    // Methods

    public void enterFirstName(String fname) {
        logger.info("Entering first name");
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        logger.info("Entering last name");
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailId) {
        logger.info("Entering email");
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterTelephone(String phone) {
        logger.info("Entering telephone number");
        driver.findElement(telephone).sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        logger.info("Entering password");
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        logger.info("Entering confirm password");
        driver.findElement(confirmPassword).sendKeys(pwd);
    }

    public void acceptPrivacyPolicy() {
        logger.info("Accepting privacy policy");
        driver.findElement(privacyPolicy).click();
    }

    public void clickContinue() {
        logger.info("Clicking Continue button");
        driver.findElement(continueButton).click();
    }

    // Business Method
    public void registerUser(String fname,
                             String lname,
                             String emailId,
                             String phone,
                             String pwd) {

        logger.info("Starting user registration");

        enterFirstName(fname);
        enterLastName(lname);
        enterEmail(emailId);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        acceptPrivacyPolicy();
        clickContinue();

        logger.info("User registration form submitted");
    }
}