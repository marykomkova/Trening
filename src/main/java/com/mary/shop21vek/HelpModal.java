package com.mary.shop21vek;

import com.mary.constant.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HelpModal extends BasePage {

    private By closeButton = new By.ByXPath("(//div[@class='popmechanic-close'])[1]");

    HelpModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfAllElementsLocatedBy(closeButton));
    }

    public void closeModal() {
        driver.findElement(closeButton).click();
    }
}
