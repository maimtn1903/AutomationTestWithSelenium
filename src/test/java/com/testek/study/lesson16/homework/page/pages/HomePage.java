package com.testek.study.lesson16.homework.page.pages;

import com.testek.driver.DriverManager;
import com.testek.study.lesson16.homework.page.objects.HomeObject;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private final HomeObject homeObject;

    public HomePage() {
        webDriver = DriverManager.getDriver();
        PageFactory.initElements(webDriver, this);

        homeObject = HomeObject.getInstance();
    }

    //***************** Init WebElement Object *****************/

    public void verifyHomePage() {
        waitForElementVisible(homeObject.findHeader());
        verifyElementTextEqual(homeObject.findHeader(), "TESTEK - KIỂM THỬ THỰC CHIẾN");
    }
}
