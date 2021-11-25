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
        LoginPage loginPage = mainPage.goToAuthentificationForm();
        Assert.assertTrue(loginPage.isOpened());
        String email = "marykomkova04@gmail.com";
        String password = "Mk6505036";
        mainPage = loginPage.authentification(email, password);
        Assert.assertTrue(mainPage.checkNames(email));
    }

}
