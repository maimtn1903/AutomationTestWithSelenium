package com.testek.finalExam.locator;

import com.testek.projects.pages.locator.BaseLocator;
import lombok.Getter;

@Getter
public class CustomerLoc extends BaseLocator {
    @Getter
    public static CustomerLoc instance = new CustomerLoc();

    private CustomerLoc() {
    }

    /* Create Customer */
    String txtCustomerName = "ID|form_item_name";
    String txtCustomerPhone = "ID|form_item_phoneNum";
    String txtCustomerEmail = "ID|form_item_email";
    String txtCustomerContact = "ID|form_item_contact";
    String txtCustomerCountry = "ID|form_item_country";
    String txtCustomerCity = "ID|form_item_city";
    String txtCustomerAddress = "ID|form_item_address";
    String txtCustomerPostalCode = "ID|form_item_postalCode";
    String btnAddCustomer = "//button[@testek='btn-add']";
    String btnAddMoreCustomer = "//button[@testek='btn-add-more']";
    String popupAddCustomerResult = "//div[contains(@class,'ant-message-success')]";
    String txtCustomerCode = "//div[@class='footer']/descendant::input[@placeholder='Mã khách hàng']";
    String txtErrorMessage = "//div[@class='footer']/descendant::textarea";
    String btnCustomerMenu = "//div[@class='menus']/descendant::span[normalize-space()='Khách hàng']/parent::button";
    String txtKeyword = "//input[contains(@class,'ant-input css-16pw25h h-8')]";
    String btnSearch = "//button[@class='css-16pw25h ant-btn ant-btn-primary']";

    /*Customer List*/
    String btnAddCustomerPage = "//button[@testek='btn-add']";
}
