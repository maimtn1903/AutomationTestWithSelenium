package com.testek.study.lesson13_14.exersise.locator;

import lombok.Getter;
import lombok.Setter;

@Getter
public class HomePageLocator {
    String imgAvatar = "//div[@testek='icon-user']";
    String imgAddButton = "//div[@testek='add']";
    String txtSearch = "//input[@testek='search-input']";

    String lblOrderCreation = "//li[@role='menuitem']//div[normalize-space()='Đơn hàng']";
}
