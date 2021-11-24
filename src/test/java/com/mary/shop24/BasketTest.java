package com.mary.shop24;

import com.mary.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isOpened());
        mainPage.searchTV();
        TVsPage tvsPage = new TVsPage(driver);
        Assert.assertTrue(tvsPage.isOpened());
        tvsPage.clickOnRandomTV();
        TVPage tvPage = new TVPage(driver);
        tvPage.isOpened();
        tvPage.addTVInBasket();
        tvPage.goToBasket();
        BasketPage basketPage = new BasketPage(driver);
        basketPage.isOpened();
    }
}
