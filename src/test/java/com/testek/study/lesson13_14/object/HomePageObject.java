package com.testek.study.lesson13_14.object;

import com.testek.projects.common.BasePage;
import com.testek.study.lesson13_14.locator.HomePageLocator;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private HomePageLocator locator;

    public HomePageObject(WebDriver webDriver) {
        this.locator = new HomePageLocator();
        this.setWebDriver(webDriver);
    }

}
