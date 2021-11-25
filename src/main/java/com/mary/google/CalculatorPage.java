package com.mary.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorPage extends BasePage {

    private By titleLabel = new By.ByXPath("//div[contains(@class, 'md-toolbar-tools')]");
    private String iframe2 = "myFrame";
    private By sectionButton = new By.ByXPath("(//div[@title='Compute Engine'])[1]");
    private By numberFirstInput = new By.ByXPath("//input[@id='input_75']");
    private By machineTypeLabel = new By.ById("select_value_label_71");
    private By valueOfMachineType = new By.ById("select_option_272");
    private By addToEstimateFirstButton = new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]");
    private By numberSecondInput = new By.ById("input_121");
    private By addGPUsSquare = new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[3]");
    private By typeOfGPU = new By.ById("select_442");
    private By valueOftypeOfGPU = new By.ById("select_option_449");
    private By numberOfGPU = new By.ById("select_value_label_441");
    private By valueOfnumberOfGPU = new By.ById("select_option_454");
    private By cpuOvercommitSquare = new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[4]");
    private By dataCenterLocation = new By.ById("select_value_label_119");
    private By valueOfdataCenterLocation = new By.ById("select_option_288");
    private By commitedUsage = new By.ById("select_value_label_120");
    private By valueOfCommitedUsage = new By.ById("select_option_140");
    private By addToEstimateSecondButton = new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[2]");
    private By totalResult = new By.ByXPath("//b[@class='ng-binding' and contains(text(), 'Total Estimated Cost')]");

    public CalculatorPage(WebDriver driver) {
        super(driver);
        driver.switchTo().frame(0);
        driver.switchTo().frame(iframe2);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public void chooseSection() {
        driver.findElement(sectionButton).click();
    }

    public void enterValuesInInstances() {
        WebElement numberInput = driver.findElement(numberFirstInput);
        numberInput.click();
        numberInput.sendKeys("4");
        driver.findElement(machineTypeLabel).click();
        driver.findElement(valueOfMachineType).click();
        driver.findElement(addToEstimateFirstButton).click();
    }

    public void enterValuesInSoleTenantNodes() {
        WebElement numberInput2 = driver.findElement(numberSecondInput);
        numberInput2.click();
        numberInput2.sendKeys("1");
        driver.findElement(addGPUsSquare).click();
        driver.findElement(typeOfGPU).click();
        driver.findElement(valueOftypeOfGPU).click();
        driver.findElement(numberOfGPU).click();
        driver.findElement(valueOfnumberOfGPU).click();
        driver.findElement(cpuOvercommitSquare).click();
        driver.findElement(dataCenterLocation).click();
        driver.findElement(valueOfdataCenterLocation).click();
        driver.findElement(commitedUsage).click();
        driver.findElement(valueOfCommitedUsage).click();
        driver.findElement(addToEstimateSecondButton).click();
    }

    public String toTakeResult() {
        String totalValue = driver.findElement(totalResult).getText();
        Pattern p = Pattern.compile("\\d+,\\d+.\\d+");
        Matcher value = p.matcher(totalValue);
        value.find();
        return value.group();
    }

}
