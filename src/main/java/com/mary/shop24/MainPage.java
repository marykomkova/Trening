package com.mary.shop24;

import com.mary.shop21vek.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private By catalogButton = new By.ByXPath("//div[@class='page-nav__cell-menu']");
    private By searchBox = new By.ByXPath("//input[@class='top-search__input white-input js-top-search-input']");

    MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(catalogButton).isDisplayed();
    }

    public void open() {
        driver.get("https://24shop.by/");
    }

    public TVsPage searchTV() {
        WebElement search = driver.findElement(searchBox);
        search.click();
        search.sendKeys("Телевизор" + Keys.ENTER);
        return new TVsPage(driver);
    }
}
