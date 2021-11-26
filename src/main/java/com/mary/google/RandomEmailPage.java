package com.mary.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RandomEmailPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h2[@class='pagetitle']");
    private By randomEmail = new By.ByXPath("//div[@id='egen']");
    private By checkEmailButton = new By.ByXPath("(//button[@class='md but text f24 egenbut'])[3]");

    public RandomEmailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public String getEmail() {
        return driver.findElement(randomEmail).getText();
    }

    public MessagePage clickOnCheckEmail() {
        driver.findElement(checkEmailButton).click();
        return new MessagePage(driver);
    }

}
