package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.SearchResultPage;

public class SearchTest extends BaseTest {

    @Test
    public void verifySearchProduct() {

        HomePage home = new HomePage(driver);

        home.searchProduct("MacBook");

        SearchResultPage result =
                new SearchResultPage(driver);

        Assert.assertTrue(result.isProductDisplayed());
    }
}
