package com.mary.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private By titleLabel = new By.ByXPath("(//div[@class='devsite-product-name-wrapper'])[1]");
    private By searchInput = new By.ByXPath("//input[@name='q']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public void openWebSite(String link) {
        driver.get(link);
    }

    public ResultsPage searchSmth(String s) {
        WebElement search = driver.findElement(searchInput);
        search.click();
        search.sendKeys(s + Keys.ENTER);
        return new ResultsPage(driver);
    }

}
