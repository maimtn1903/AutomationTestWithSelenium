package com.testek.study.lesson16.homework.page.locator;

public class BaseLocator {
    public static final String ADD_BUTTON_XPATH = "//button[@testek = 'btn-add']"; // Nút Thêm
    public static final String ADD_MORE_BUTTON_XPATH = "//button[@testek = 'btn-add-more']";
    public static final String POPUP_ADD_PRODUCT_SUCCESS_XPATH = "//div[contains(@class,'ant-message-success')]";
    public static final String CHB_SEARCH_XPATH = "//div[contains(@class,'search-text')]/child::input[@testek='search-input']";
    public static final String BTN_SEARCH_XPATH = "//button[@testek='btn-search']";
    public static final String SEARCH_RESULT_XPATH = "//tr[starts-with(@class, 'ant-table-row')]";
}
