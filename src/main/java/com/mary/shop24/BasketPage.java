package com.mary.shop24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1[@class='page-main__title']");
    private By actualNameOfTV = new By.ByCssSelector("h4 > a");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public String findActualNameOfTV() {
        return driver.findElement(actualNameOfTV).getText();
    }
}
