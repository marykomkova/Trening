package com.mary.shop24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1[@class='page-main__title']");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }
}
