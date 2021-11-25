package com.mary.shop21vek;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AuthentificationTest extends BasketTest {
    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isOpened());
        mainPage.goToAuthentificationForm();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isOpened());
        loginPage.authentification("marykomkova04@gmail.com", "Mk6505036");
        MainPage mainPage2 = new MainPage(driver);
        Assert.assertTrue(mainPage.isOpened());
    }

}
