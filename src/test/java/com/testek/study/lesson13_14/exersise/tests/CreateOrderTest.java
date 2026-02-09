package com.testek.study.lesson13_14.exersise.tests;

import com.testek.study.lesson13_14.exersise.TestBase;
import com.testek.study.lesson13_14.exersise.page.HomePage;
import com.testek.study.lesson13_14.exersise.page.LoginPage;
import com.testek.study.lesson13_14.exersise.page.OrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrderTest extends TestBase {
    LoginPage loginPage;
    WebDriver webDriver;

    /**
     * Setup before each test method
     */
    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);

        loginPage = new LoginPage(webDriver);
        loginPage.accessWebsite();
    }

    @AfterMethod
    public void afterMethod() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void createOrder() {
        HomePage homePage = loginPage.loginSuccess("admin_com_role", "aA12345678@");
        homePage.verifyHomePageDisplayed();

        OrderPage orderPage = homePage.accessCreateOrderPage();
        orderPage.fillOrderInfo("LINH CHI", "0987654321", "0987654321", "vn.labit@gmail.com", "123 Đường Láng - Hà Nội", "Mai Quỳnh Chi");
        orderPage.verifyCreateOrderSuccess();

        System.out.println();
    }
}
