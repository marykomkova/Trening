package com.mary.shop24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class TVsPage extends BasePage {

    private By tvs = new By.ByXPath("//a[@class='pseudo-link']");
    private By resultsOfSearchLabel = new By.ByXPath("//h1[@class='page-main__title']");

    public TVsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(resultsOfSearchLabel).isDisplayed();
    }

    public TVPage clickOnRandomTV() {
        List<WebElement> allProducts = driver.findElements(tvs);
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
        return new TVPage(driver);
    }
}
