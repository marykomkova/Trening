package com.mary.google;

import com.mary.constant.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailYourEstimateForm extends BasePage {

    private By titleLabel = new By.ByXPath("(//h2[@class='md-toolbar-tools'])[4]");
    private By emailInput = new By.ByXPath("//input[@id='input_473']");
    private By sendEmailButton = new By.ByXPath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and contains(text(), 'Send Email')]");

    public EmailYourEstimateForm(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public void sendResultOnEmail(String email) {
        //driver.switchTo().frame(0);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(sendEmailButton).click();
        //return new CalculatorPage(driver);
    }

}
