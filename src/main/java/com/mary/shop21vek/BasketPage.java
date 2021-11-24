package com.mary.shop21vek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends BasePage {

    private By logotype = new By.ByCssSelector("span.BasketTabsScreen_title__2NSA4");
    private By actualName = new By.ByCssSelector("td.cr-basket__name > a");

    BasketPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getBasketItemsNames() {
        return driver.findElements(actualName).stream().map(el -> el.getText()).collect(Collectors.toList());
        //List<String> names=new ArrayList<>();
        //for (WebElement el: trashesNames) {
        //    names.add(el.getText());
        //}
        //https://metanit.com/java/tutorial/10.13.php
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(logotype).isDisplayed();
    }
}
