package com.mary.shop21vek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h5[@class='style_formTitle__hRNRz']");
    private By emailLabel = new By.ByXPath("//input[@id='login-email']");
    private By passwordLabel = new By.ByXPath("//input[@name='password']");
    private By loginButtonSecond = new By.ByXPath("//button[@class='styles_reactButton__2olKd style_baseActionButton__2LQYJ styles_submitButton__lmwVK']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public MainPage authentification(String email, String password) {
        driver.findElement(emailLabel).sendKeys(email);
        driver.findElement(passwordLabel).sendKeys(password);
        driver.findElement(loginButtonSecond).click();
        return new MainPage(driver);
    }

}
