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
        calculatorPage.goToFrame();
        Assert.assertTrue(calculatorPage.isOpened());
        calculatorPage.chooseSection();
        calculatorPage.enterNumberOfInstances();
        calculatorPage.enterMachineType();
        calculatorPage.clickAddToEstimateFirst();
        calculatorPage.enterNumberOfTenantNodes();
        calculatorPage.clickOnAddGPUs();
        calculatorPage.enterGpuValues();
        calculatorPage.clickOnCpuOvercommit();
        calculatorPage.enterDataCenterLocation();
        calculatorPage.enterCommitedUsage();
        calculatorPage.clickOnAddToEstimateSecond();
        String googleResult = calculatorPage.toTakeResult();
        calculatorPage.openNewWindow("https://yopmail.com/");
        YopMailPage yopMailPage = new YopMailPage(driver);
        Assert.assertTrue(yopMailPage.isOpened());
        RandomEmailPage randomEmailPage = yopMailPage.generateRandomEmail();
        Assert.assertTrue(randomEmailPage.isOpened());
        String email = randomEmailPage.getEmail();
        randomEmailPage.switchWindow();
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.goToFrame();
        EmailYourEstimateForm emailYourEstimateForm = calculatorPage.clickOnEmailEstimate();
        Assert.assertTrue(emailYourEstimateForm.isOpened());
        emailYourEstimateForm.sendResultOnEmail(email);
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.switchWindow();
        randomEmailPage = new RandomEmailPage(driver);
        MessagePage messagePage = randomEmailPage.clickOnCheckEmail();
        String emailResult = messagePage.toTakeResult();
        System.out.println("Expected result: " + googleResult + "\nActual result: " + emailResult);
        Assert.assertEquals(googleResult, emailResult);
    }
}
