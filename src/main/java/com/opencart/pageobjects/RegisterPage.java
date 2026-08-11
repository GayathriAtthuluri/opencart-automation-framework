package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.base.BasePage;

public class RegisterPage extends BasePage {

    

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
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailId) {
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterTelephone(String phone) {
        driver.findElement(telephone).sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        driver.findElement(confirmPassword).sendKeys(pwd);
    }

    public void acceptPrivacyPolicy() {
        driver.findElement(privacyPolicy).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    // Business Method
    public void registerUser(String fname,
                             String lname,
                             String emailId,
                             String phone,
                             String pwd) {

        enterFirstName(fname);
        enterLastName(lname);
        enterEmail(emailId);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        acceptPrivacyPolicy();
        clickContinue();
    }

}
