package com.mary.shop24;

import com.mary.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasketTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isOpened());
        ProductsPage productsPage = mainPage.searchProduct("Телевизор");
        Assert.assertTrue(productsPage.isOpened());
        Random rand = new Random();
        int randomIndexOfProduct = rand.nextInt(productsPage.getProductsNames().size());
        ProductPage productPage = productsPage.clickOnProductItem(randomIndexOfProduct);
        Assert.assertTrue(productPage.isOpened());
        productPage.addProductInBasket();
        String expectedNameOfSelectedProduct = productPage.getNameOfSelectedProduct();
        BasketPage basketPage = productPage.goToBasket();
        Assert.assertTrue(basketPage.isOpened());
        String actualNameOfTV = basketPage.findActualNameOfTV();
        Assert.assertEquals(expectedNameOfSelectedProduct, actualNameOfTV);
    }
}
