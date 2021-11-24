package com.mary.shop21vek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class GoodPage extends BasePage {

    private By logotype = new By.ByXPath("//h1[@class='content__header cr-category_header']");
    private By addButton = new By.ByXPath("//button[@class='g-button g-buybtn result__buybtn cr-buybtn__in j-ga_track']");
    private By names = new By.ByXPath("//span[@class='result__name']");
    private By selectedProduct = new By.ByXPath("//a[@class='j-button-clicked g-basketbtn']");

    GoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(logotype).isDisplayed();
    }

    public String addInBasket() {
        HelpModal helpModal = new HelpModal(driver);
        if (helpModal.isOpened()) {
            helpModal.closeModal();
        }
        List<WebElement> allProducts = driver.findElements(addButton);
        List<WebElement> allNames = driver.findElements(names);
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
        return allNames.get(randomProduct).getText();
    }

    public BasketPage openBasket() {
//        HelpModal helpModal = new HelpModal(driver);
//        if (helpModal.isOpened()) {
//            helpModal.closeModal();
//        }
        driver.findElement(selectedProduct).click();
        return new BasketPage(driver);
    }

}
