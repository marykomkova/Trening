package com.mary.shop21vek;

import com.mary.constant.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(TimeConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public abstract boolean isOpened();

    public boolean waitUntilElementPresence(By locator, int timeout) {
        FluentWait wait = (new WebDriverWait(driver, timeout)).ignoring(WebDriverException.class).ignoring(NoSuchElementException.class);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception exception) {
            System.out.println("Element" + locator + "wasn't found");
            return false;
        }
        return true;
    }

    public boolean waitUntilElementPresence(By locator) {
        return waitUntilElementPresence(locator, TimeConstants.PAGE_LOAD_TIMEOUT);
    }
}
