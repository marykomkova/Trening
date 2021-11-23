package com.mary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    protected WebDriver driver;
    private By logotype = new By.ByCssSelector("span.BasketTabsScreen_title__2NSA4");

    BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpened() {
        return driver.findElement(logotype).isDisplayed();
    }
}
