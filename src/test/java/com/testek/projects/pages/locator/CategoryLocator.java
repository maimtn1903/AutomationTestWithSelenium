package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class CategoryLocator extends BaseLocator {
    @Getter
    public static CategoryLocator instance = new CategoryLocator();

    private CategoryLocator() {
    }

    /* Create Category */
    String txtName = "ID|form_item_categoryName";
    String txtStatus = "ID|form_item_status";
    String formItemStatus = "ID|form_item_status";
    String txtDescription = "ID|form_item_cateDesc";
    String btnAddCategory = "//button[@testek='btn-add']";
    String btnAddMoreCategory = "//button[@testek='btn-add-more']";
    String popupAddCategoryResult = "//div[contains(@class,'ant-message-success')]";
    String txtCategoryCode = "//div[@class='footer']/descendant::input[@placeholder='Mã danh mục']";
    String txtErrorMessage = "//div[@class='footer']/descendant::textarea";
    String btnCustomerMenu = "//div[@class='menus']/descendant::span[normalize-space()='Sản phẩm']/parent::button";
    String txtSearch = "//input[@class='ant-input css-16pw25h']";
    String txtKeyword = "//input[contains(@class,'ant-input css-16pw25h h-8')]";
    String btnSearch = "//button[@class='css-16pw25h ant-btn ant-btn-primary']";
    String btnYes = "//span[normalize-space()='Có']";

    /*Category List*/
    String lblRowContent = "//div[text()='%s']";
    String btnAddCategoryPage = "//button[@testek='btn-add']";
    String btnEditCategory = "//div[normalize-space()='%s'] /ancestor::tr //div[@title='Sửa']";
    String btnDeleteCategory = "//div[normalize-space()='%s'] /ancestor::tr //div[@title='Xóa']";
}
