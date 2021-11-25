package com.mary.google;

import com.mary.constant.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1[@class='devsite-search-title']");
    private By desiredResult = new By.ByXPath("(//a[@class='gs-title'])[1]");// and contains(text(), 'Google Cloud Pricing Calculator')]");//"a.gs-title > b"

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public CalculatorPage clickOnLink() {
        driver.navigate().refresh();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(desiredResult));
        driver.findElement(desiredResult).click();
        return new CalculatorPage(driver);
    }
}
