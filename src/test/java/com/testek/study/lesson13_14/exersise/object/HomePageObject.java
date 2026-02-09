package com.testek.study.lesson13_14.exersise.object;

import com.testek.study.lesson13_14.exersise.locator.HomePageLocator;
import com.testek.study.lesson13_14.exersise.page.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
public class HomePageObject extends BasePage {
    private HomePageLocator locator;

    public HomePageObject(WebDriver webDriver) {
        this.locator = new HomePageLocator();
        this.setWebDriver(webDriver);
    }

    // Find Element
    public WebElement findAvatar() {
        return findElement(By.xpath(locator.getImgAvatar()));
    }

    public WebElement findAddNewItemButton() {
        return findElement(By.xpath(locator.getImgAddButton()));
    }

    public WebElement findSearchTextBox() {
        return findElement(By.xpath(locator.getTxtSearch()));
    }

    public WebElement findCreateOrder() {
        return findElement(By.xpath(locator.getLblOrderCreation()));
    }


    /**
     * Click to [Add New Item] button
     */
    public void clickAddNewItemButton() {
        clickTo(findAddNewItemButton(), "Click Add New Item Button");
    }

    /**
     * Click to [Order Creation] link
     */
    public void clickCreateOrderLink() {
        clickTo(findCreateOrder(), "Click Order Creation Link");
    }

    /**
     * Verify that the avatar is displayed on the home page.
     */
    public void verifyAvatarIsDisplayed() {
        assertTrue(findAvatar().isDisplayed(), "Avatar is displayed");
    }


}
