package com.mary.shop24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TVPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1[@class='page-main__title']");
    private By addInBasketButton = new By.ByXPath("(//button[@class='new-button new-button_border'])[1]");
    private By goToBasketButton = new By.ByXPath("(//button[@class='new-button new-button_border'])[2]");

    public TVPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public String addTVInBasket() {
        driver.findElement(addInBasketButton).click();
        return driver.findElement(titleLabel).getText();
    }

    public BasketPage goToBasket() {
        driver.findElement(goToBasketButton).click();
        return new BasketPage(driver);
    }

}
