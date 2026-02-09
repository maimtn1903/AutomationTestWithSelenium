package com.testek.study.lesson13_14.exersise.locator;

import lombok.Getter;

@Getter
public class LoginLocator {
    String imgLogo = "//div[contains(@class,'logo-system')]";
    String txtUsername = "//input[@id='normal_login_username']";
    String txtPassword = "//input[@id='normal_login_password']";
    String btnLogin = "//button[@type='submit']";
}


