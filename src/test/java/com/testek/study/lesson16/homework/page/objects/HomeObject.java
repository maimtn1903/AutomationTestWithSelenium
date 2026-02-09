package com.testek.study.lesson16.homework.page.objects;

import com.testek.study.lesson16.homework.page.locator.HomeLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class HomeObject extends BaseObjects {
    @Getter
    public static HomeObject instance = new HomeObject();

    private final HomeLocator homeLocator;

    private HomeObject() {
        homeLocator = HomeLocator.getInstance();
    }

    public WebElement findHeader() {
        return findWebElement(homeLocator.getLblHeader());
    }
}
