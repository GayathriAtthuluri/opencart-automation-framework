package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import com.opencart.pageobjects.RegistrationSuccessPage;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "registerData",
          dataProviderClass = RegisterDataProvider.class)
    public void verifyUserRegistration(
            String firstName,
            String lastName,
            String email,
            String phone,
            String password) {

        // Print test data to verify DataProvider
        System.out.println(
                firstName + " | " +
                lastName + " | " +
                email + " | " +
                phone + " | " +
                password);

        // Navigate to Register page
        HomePage home = new HomePage(driver);
        home.navigateToRegisterPage();

        // Create Register Page object
        RegisterPage register = new RegisterPage(driver);

        // Register user using DataProvider data
        register.registerUser(
                firstName,
                lastName,
                email,
                phone,
                password);

        // Verify registration success
        RegistrationSuccessPage success =
                new RegistrationSuccessPage(driver);

        Assert.assertTrue(
                success.isRegistrationSuccessful(),
                "Registration was not successful");
    }
}