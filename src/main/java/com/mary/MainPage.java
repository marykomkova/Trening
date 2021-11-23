package com.mary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    protected WebDriver driver;

    MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By title = new By.ByCssSelector("a.logotypeImg");
    private By basket = new By.ByCssSelector("a.headerCartBox");

    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public void open() {
        driver.get("https://www.21vek.by/");
    }

    public BasketPage openBasket() {
        driver.findElement(basket).click();
        return new BasketPage(driver);
    }

}
