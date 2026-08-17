package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.utilities.ConfigReader;
@Listeners(TestListener.class)

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        HomePage home = new HomePage(driver);
        home.navigateToLoginPage();

        LoginPage login = new LoginPage(driver);

        login.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password"));

        AccountPage account = new AccountPage(driver);

        Assert.assertTrue(account.isMyAccountPageDisplayed(),
                "Login Failed!");
    }
}
