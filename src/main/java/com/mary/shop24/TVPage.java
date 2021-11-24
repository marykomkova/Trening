package com.mary.shop24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TVPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1[@class='page-main__title']");
    private By addInBasketButton = new By.ByXPath("(//button[@class='new-button new-button_border'])[1]");
    private By goToBasketButton = new By.ByXPath("//span[@class='page-header-bottom-btn__txt']");

    public TVPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public void addTVInBasket() {
        driver.findElement(addInBasketButton).click();
    }

    public BasketPage goToBasket() {
        driver.findElement(goToBasketButton).click();
        return new BasketPage(driver);
    }

}
