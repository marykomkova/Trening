package com.mary;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class GoodPage {

    protected WebDriver driver;
    private By logotype = new By.ByXPath("//h1[@class='content__header cr-category_header']");
    private By addButton = new By.ByXPath("//button[@class='g-button g-buybtn result__buybtn cr-buybtn__in j-ga_track']");
    private By names = new By.ByXPath("//span[@class='result__name']");
    private By selectedProduct = new By.ByXPath("//a[@class='j-button-clicked g-basketbtn']");

    GoodPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpened() {
        return driver.findElement(logotype).isDisplayed();
    }

    public String addInBasket() {
       // WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//div[@class='popmechanic-close']")));
        //driver.findElement(new By.ByXPath("//div[@class='popmechanic-close']")).click();
        List<WebElement> allProducts = driver.findElements(addButton);
        List<WebElement> allNames = driver.findElements(names);
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
        return allNames.get(randomProduct).getText();
    }

    //public BasketPage
}
