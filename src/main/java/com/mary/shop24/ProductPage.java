package com.mary.shop24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1[@class='page-main__title']");
    private By addInBasketButton = new By.ByXPath("(//button[@class='new-button new-button_border'])[1]");
    private By goToBasketButton = new By.ByXPath("(//button[@class='new-button new-button_border'])[2]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public void addProductInBasket() {
        driver.findElement(addInBasketButton).click();
    }

    public String getNameOfSelectedProduct() {
        String expectedNameOfProduct = driver.findElement(titleLabel).getText();
//        Pattern p = Pattern.compile("Код: \\d+");
//        Matcher ex = p.matcher(expectedNameOfProduct);
//        ex.find();
        return expectedNameOfProduct.replaceAll("Код: \\d+", "");
        //return expectedNameOfProduct.replace(expectedNameOfProduct.substring(ex.start(), ex.end()), "");
    }

    public BasketPage goToBasket() {
        driver.findElement(goToBasketButton).click();
        return new BasketPage(driver);
    }

}
