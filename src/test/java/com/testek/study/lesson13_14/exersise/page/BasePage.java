package com.testek.study.lesson13_14.exersise.page;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Setter
@Getter
public class BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    WebDriverWait getWebWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        }
        return webDriverWait;
    }

    /**
     * Constructor to initialize WebDriver and WebDriverWait
     *
     * @param locator: By locator to find the element
     * @return WebElement found
     */
    public WebElement findElement(By locator) {
        return getWebWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Click to element with description
     *
     * @param locator      : By locator to find the element
     * @param description: Description of the element
     */
    public void clickTo(By locator, String description) {
        WebElement element = findElement(locator);
        clickTo(element, description);
    }

    /**
     * Click to element with description
     *
     * @param element      : WebElement to click
     * @param description: Description of the element
     */
    public void clickTo(WebElement element, String description) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(element));

        element.click();
        System.out.println("Clicked to: " + description);
    }

    /**
     * Input text to element with description
     *
     * @param element:     WebElement to input text
     * @param description: Description of the element
     * @param text:        Text to input
     * @param isClear:     Whether to clear the existing text before inputting
     */
    public void inputText(WebElement element, String description, String text, boolean isClear) {
        if (isClear) element.clear();
        element.sendKeys(text);
        System.out.println("Input text to " + description + ": " + text);
    }

    public void assertTrue(boolean condition, String message) {
        System.out.println("Verifying condition: " + message + " - Result: " + condition);
        Assert.assertTrue(condition, message);
    }
}
