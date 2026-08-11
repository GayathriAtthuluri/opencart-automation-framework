package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.LogoutPage;
import com.opencart.utilities.ConfigReader;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {

        // Navigate to Login Page
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password"));

        // Verify Login
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isMyAccountPageDisplayed(),
                "Login Failed!");

        // Logout
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.navigateToLogoutPage();

        // Verify Logout
        Assert.assertTrue(logoutPage.isLogoutSuccessful(),
                "Logout Failed!");
    }
}