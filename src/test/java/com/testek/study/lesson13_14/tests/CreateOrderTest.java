package com.testek.study.lesson13_14.tests;

import com.testek.study.lesson13_14.TestBase;
import com.testek.study.lesson13_14.page.HomePage;
import com.testek.study.lesson13_14.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    @Test
    public void createOrder() {
        HomePage homePage = loginPage.loginSuccess("labIT", "aA12345678@");
        // Implement your test steps here
    }
}
