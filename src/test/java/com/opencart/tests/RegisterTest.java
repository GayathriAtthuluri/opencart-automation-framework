package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import com.opencart.pageobjects.RegistrationSuccessPage;

public class RegisterTest extends BaseTest {

    @Test
    public void verifyUserRegistration() {

        HomePage home = new HomePage(driver);
        home.navigateToRegisterPage();

        RegisterPage register = new RegisterPage(driver);

        String email = "user" + System.currentTimeMillis() + "@gmail.com";

        register.registerUser(
                "David",
                "Miller",
                email,
                "9876543210",
                "Password@123");

        RegistrationSuccessPage success =
                new RegistrationSuccessPage(driver);

        Assert.assertTrue(success.isRegistrationSuccessful());
    }
}
