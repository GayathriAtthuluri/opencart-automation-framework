package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.SearchResultPage;
import com.opencart.pageobjects.ShoppingCartPage;
import com.opencart.utilities.ConfigReader;

public class RemoveProductTest extends BaseTest {

    @Test
    public void verifyRemoveProduct() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password"));

        homePage.searchProduct("MacBook");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.isProductDisplayed(),
                "Product Not Found!");

        searchResultPage.clickProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddtoCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickShoppingCart();

        shoppingCartPage.removeProduct();

        Assert.assertTrue(
                shoppingCartPage.isCartEmpty(),
                "Product was not removed from the cart!");
    }
}