package com.testek.study.lesson16.homework.page.objects;

import com.testek.driver.DriverManager;
import com.testek.projects.common.BasePage;
import com.testek.study.lesson16.homework.page.locator.BaseLocator;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class BaseObjects extends BasePage {
    protected WebDriver webDriver;

    public BaseObjects() {
        this.webDriver = DriverManager.getDriver();
    }

    public WebElement findBtnAddEle() {
        return findWebElement(BaseLocator.ADD_BUTTON_XPATH);
    }

    public WebElement findBtnAddMoreEle() {
        return findWebElement(BaseLocator.ADD_MORE_BUTTON_XPATH);
    }

    public WebElement findPopUpAddProductResultEle() {
        return findWebElement(BaseLocator.POPUP_ADD_PRODUCT_SUCCESS_XPATH);
    }

    public void clickAddButton() {
        clickTo(findBtnAddEle(), "Click Add button");
    }

    public void clickAddMoreButton() {
        clickTo(findBtnAddMoreEle(), "Click Add More button");
    }

}
