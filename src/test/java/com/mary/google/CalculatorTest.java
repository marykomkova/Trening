package com.mary.google;

import com.mary.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openWebSite("https://cloud.google.com/");
        Assert.assertTrue(mainPage.isOpened());
        ResultsPage resultsPage = mainPage.searchSmth("Google Cloud Pricing Calculator");
        Assert.assertTrue(resultsPage.isOpened());
        CalculatorPage calculatorPage = resultsPage.clickOnLink();
        Assert.assertTrue(calculatorPage.isOpened());
        calculatorPage.chooseSection();
        calculatorPage.enterValuesInInstances();
        calculatorPage.enterValuesInSoleTenantNodes();
        System.out.println(calculatorPage.toTakeResult());
    }
}
