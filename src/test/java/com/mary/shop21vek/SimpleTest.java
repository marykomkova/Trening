package com.mary.shop21vek;

import com.mary.BaseTest;
import com.mary.shop21vek.BasketPage;
import com.mary.shop21vek.MainPage;
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
