package com.mary.shop21vek;

import com.mary.constant.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    MainPage(WebDriver driver) {
        super(driver);
    }

    private By title = new By.ByCssSelector("a.logotypeImg");
    private By basket = new By.ByCssSelector("a.headerCartBox");
    private By search = new By.ByXPath("//input[@id='j-search']");
    private By accountButton = new By.ByXPath("//span[contains(text(), 'Аккаунт')]");
    private By accountButton2 = new By.ByXPath("//button[@class='styles_userToolsToggler__imcSl']");
    private By loginButton = new By.ByXPath("//button[@class='userToolsBtn']");
    private By actualEmail = new By.ByXPath("//span[@class='userToolsSubtitle']");

    @Override
    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public void open() {
        driver.get("https://www.21vek.by/");
    }

    public BasketPage openBasket() {
        driver.findElement(basket).click();
        return new BasketPage(driver);
    }
    public GoodPage searchGood() {
        WebElement searchBox = driver.findElement(search);
        searchBox.click();
        searchBox.sendKeys("Планетарный миксер" + Keys.ENTER);
        return new GoodPage(driver);
    }

    public LoginPage goToAuthentificationForm() {
        driver.findElement(accountButton).click();
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public boolean checkNames(String inputedEmail) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(accountButton));
        driver.findElement(accountButton).click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String a = driver.findElement(actualEmail).getText();
        return (a.equals(inputedEmail));
    }

}
