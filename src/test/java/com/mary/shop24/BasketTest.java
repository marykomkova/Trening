package com.mary.shop24;

import com.mary.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String expectedNameOfTV = tvPage.addTVInBasket();
        Pattern p = Pattern.compile("Код: \\d+");
        Matcher ex = p.matcher(expectedNameOfTV);
        ex.find();
        tvPage.goToBasket();
        BasketPage basketPage = new BasketPage(driver);
        basketPage.isOpened();
        String actualNameOfTV = basketPage.findActualNameOfTV();
        Assert.assertEquals(expectedNameOfTV.replace(expectedNameOfTV.substring(ex.start(), ex.end()), ""), actualNameOfTV);
    }
}
