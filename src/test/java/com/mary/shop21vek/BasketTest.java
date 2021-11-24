package com.mary.shop21vek;

import com.mary.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BasketTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isOpened());
        mainPage.searchGood();
        GoodPage goodPage = new GoodPage(driver);
        Assert.assertTrue(goodPage.isOpened());
        String expectedName = goodPage.addInBasket();
        goodPage.openBasket();
        BasketPage basketPage = new BasketPage(driver);
        List<String> basketItemsNames = basketPage.getBasketItemsNames();
        Assert.assertEquals(expectedName, basketItemsNames.get(0));
    }
}
