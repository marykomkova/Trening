package com.mary.google;

import com.mary.constant.TimeConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(TimeConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        new WebDriverWait(this.driver, TimeConstants.PAGE_LOAD_TIMEOUT).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public abstract boolean isOpened();

    public boolean waitUntil(int timeout, ExpectedCondition condition) {
        FluentWait wait = (new WebDriverWait(driver, timeout)).ignoring(WebDriverException.class).ignoring(NoSuchElementException.class);
        try {
            wait.until(condition);
        } catch (Exception exception) {
            System.out.println("Element wasn't found");
            return false;
        }
        return true;
    }

    public void openNewWindow(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchWindow();
        driver.get(url);
    }

    public void switchWindow() {
        for (String windowName: driver.getWindowHandles()) {
            if (!driver.getWindowHandle().equals(windowName)) {
                driver.switchTo().window(windowName);
                break;
            }
        }
    }
}
