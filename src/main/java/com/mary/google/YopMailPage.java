package com.mary.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YopMailPage extends BasePage {

    private By titleLabel = new By.ByXPath("//span[@class='notmobile']");
    private By clickRandomEmail = new By.ByXPath("(//div[@class='txtlien'])[1]");

    public YopMailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public RandomEmailPage generateRandomEmail() {
        driver.findElement(clickRandomEmail).click();
        return new RandomEmailPage(driver);
    }
}
