package com.testek.study.lesson16.homework.page.locator;

import lombok.Getter;

@Getter
public class HomeLocator extends BaseLocator {
    @Getter
    public static HomeLocator instance = new HomeLocator();

    private HomeLocator() {
    }
    String lblHeader = "//div[@id='about-me']/h2";
}
