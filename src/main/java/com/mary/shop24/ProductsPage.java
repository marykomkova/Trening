package com.mary.shop24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private By products = new By.ByXPath("//a[@class='pseudo-link']");
    private By resultsOfSearchLabel = new By.ByXPath("//h1[@class='page-main__title']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(resultsOfSearchLabel).isDisplayed();
    }

    public ProductPage clickOnProductItem(int randomIndexOfProduct) {
        List<WebElement> allProducts = driver.findElements(products);
        allProducts.get(randomIndexOfProduct).click();
        return new ProductPage(driver);
    }

    public List<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(products);
        return allProducts.stream().map(el -> el.getText()).collect(Collectors.toList());
    }
}
