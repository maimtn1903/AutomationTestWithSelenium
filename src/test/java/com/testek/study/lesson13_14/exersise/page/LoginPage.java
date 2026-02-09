package com.testek.study.lesson13_14.exersise.page;

import com.testek.study.lesson13_14.exersise.object.LoginObject;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Setter
@Getter
public class LoginPage extends BasePage {
    private LoginObject loginObject;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.loginObject = new LoginObject(webDriver);
    }

    /**
     * Login with username and password
     *
     * @param username : Username
     * @param password : Password
     * @return : HomePage
     */
    public HomePage loginSuccess(String username, String password) {
        login(username, password);
        return new HomePage(webDriver);
    }

    /**
     * Login method
     */
    public void login(String username, String password) {
        loginObject.inputUsername(username);
        loginObject.inputPassword(password);
        loginObject.clickLoginButton();
    }

    public void accessWebsite() {
        webDriver.get("https://testek.vn/lab/auto/login");
    }
}
