package com.mary.google;

import com.mary.constant.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessagePage extends BasePage {

    private By titlePage = new By.ByXPath("//div[@class='bname']");
    private By result = new By.ByTagName("h2");

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titlePage).isDisplayed();
    }

    public String toTakeResult() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(result));
        driver.switchTo().frame("ifmail");
        String emailResult = driver.findElement(result).getText();
        Pattern p = Pattern.compile("\\d+,\\d+.\\d+");
        Matcher value = p.matcher(emailResult);
        value.find();
        return value.group();
    }
}
