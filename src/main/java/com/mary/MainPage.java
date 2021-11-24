package com.mary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    MainPage(WebDriver driver) {
        super(driver);
    }

    private By title = new By.ByCssSelector("a.logotypeImg");
    private By basket = new By.ByCssSelector("a.headerCartBox");
    private By search = new By.ByXPath("//input[@id='j-search']");

    @Override
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
    public GoodPage searchGood() {
        WebElement searchBox = driver.findElement(search);
        searchBox.click();
        searchBox.sendKeys("Планетарный миксер" + Keys.ENTER);
        return new GoodPage(driver);
    }

}
