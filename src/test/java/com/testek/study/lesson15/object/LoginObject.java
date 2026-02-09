package com.testek.study.lesson15.object;

import com.testek.study.lesson15.locator.LoginLocator;
import com.testek.study.lesson15.page.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Setter
@Getter
public class LoginObject extends BasePage {
    private LoginLocator locator;

    public LoginObject(WebDriver webDriver) {
        this.locator = new LoginLocator();
        this.setWebDriver(webDriver);
    }


    // Find Element
    public WebElement findUsernameInput() {
        return findElement(By.xpath(locator.getTxtUsername()));
    }

    public WebElement findPasswordInput() {
        return findElement(By.xpath(locator.getTxtPassword()));
    }

    public WebElement findLoginButton() {
        return findElement(By.xpath(locator.getBtnLogin()));
    }

    public WebElement findLogoEle() {
        return findElement(By.xpath(locator.getImgLogo()));
    }

    // Actions
    /* Input user to [UserName]*/
    public void inputUsername(String user) {
        inputText(findUsernameInput(), "Input Username", user, true);
    }

    /* Input password to [Password]*/
    public void inputPassword(String password) {
        inputText(findPasswordInput(), "Input Password", password, true);
    }

    /* Click to [Login] button*/
    public void clickLoginButton() {
        clickTo(findLoginButton(), "Click Login Button");
    }

    /**
     * Verify that the logo is displayed on the login page.`
     */
    public void verifyLogoIsDisplayed() {
        Assert.assertTrue(findLogoEle().isDisplayed(), "Logo is not displayed");
    }
}
