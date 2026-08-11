package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.LogoutPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.RegisterPage;
import com.opencart.pageobjects.RegistrationSuccessPage;
import com.opencart.pageobjects.SearchResultPage;
import com.opencart.pageobjects.ShoppingCartPage;

public class E2ETest extends BaseTest {

    @Test
    public void verifyCompleteUserJourney() {

        // Home Page
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        // Register
        RegisterPage registerPage = new RegisterPage(driver);

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        String password = "Password@123";

        registerPage.registerUser(
                "David",
                "Miller",
                email,
                "9876543210",
                password);

        // Registration Success
        RegistrationSuccessPage successPage = new RegistrationSuccessPage(driver);
        Assert.assertTrue(successPage.isRegistrationSuccessful(),
                "Registration Failed!");

        // Logout
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.navigateToLogoutPage();
        Assert.assertTrue(logoutPage.isLogoutSuccessful(),
                "Logout Failed!");

        // Login
        HomePage homePage2 = new HomePage(driver);
        homePage2.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        // Account
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isMyAccountPageDisplayed(),
                "Login Failed!");

        // Search Product
        homePage2.searchProduct("MacBook");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.isProductDisplayed(),
                "Product Not Found!");

        searchResultPage.clickProduct();

        // Product Page
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductName(),
                "MacBook",
                "Incorrect Product!");

        // Add To Cart
        productPage.clickAddtoCart();

        // Shopping Cart
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickShoppingCart();

        Assert.assertTrue(shoppingCartPage.isProductAdded("MacBook"),
                "Product was not added to cart!");

        shoppingCartPage.removeProduct();

        Assert.assertTrue(shoppingCartPage.isCartEmpty(),
                "Cart is not empty!");

        // Final Logout
        LogoutPage logoutPage2 = new LogoutPage(driver);
        logoutPage2.navigateToLogoutPage();

        Assert.assertTrue(logoutPage2.isLogoutSuccessful(),
                "Final Logout Failed!");
    }
}
