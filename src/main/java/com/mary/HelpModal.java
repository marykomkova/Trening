package com.mary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpModal extends BasePage {

    private By closeButton = new By.ByXPath("(//div[@class='popmechanic-close'])[1]");

    HelpModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return waitUntilElementPresence(closeButton);
    }

    public void closeModal() {
        driver.findElement(closeButton).click();
    }
}
