package com.mary;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isOpened());
        BasketPage basketPage = mainPage.openBasket();
        Assert.assertTrue(basketPage.isOpened());
    }
}
