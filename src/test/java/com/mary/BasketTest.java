package com.mary;

import org.testng.Assert;

import org.testng.annotations.Test;

public class BasketTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isOpened());
        mainPage.searchGood();
        GoodPage goodPage = new GoodPage(driver);
        Assert.assertTrue(goodPage.isOpened());
        //goodPage.addInBasket();
        System.out.println(goodPage.addInBasket());
    }
}
