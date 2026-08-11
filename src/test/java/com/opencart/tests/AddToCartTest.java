package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.SearchResultPage;
import com.opencart.pageobjects.ShoppingCartPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {

        HomePage home = new HomePage(driver);

        home.searchProduct("MacBook");

        SearchResultPage result =
                new SearchResultPage(driver);

        result.clickProduct();

        ProductPage product =
                new ProductPage(driver);

        product.clickAddtoCart();

        ShoppingCartPage cart =
                new ShoppingCartPage(driver);

        cart.clickShoppingCart();

        Assert.assertTrue(cart.isProductAdded("MacBook"));
    }
}