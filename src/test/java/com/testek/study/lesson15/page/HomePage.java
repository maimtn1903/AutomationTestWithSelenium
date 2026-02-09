package com.testek.study.lesson15.page;

import com.testek.study.lesson15.object.HomePageObject;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private HomePageObject homePageObject;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.homePageObject = new HomePageObject(webDriver);
    }

    /**
     * Access Create Order Page
     */
    public OrderPage accessCreateOrderPage() {
        homePageObject.clickAddNewItemButton();
        homePageObject.clickCreateOrderLink();
        return new OrderPage(webDriver);
    }

    public void verifyHomePageDisplayed() {
        homePageObject.verifyAvatarIsDisplayed();
    }
}
