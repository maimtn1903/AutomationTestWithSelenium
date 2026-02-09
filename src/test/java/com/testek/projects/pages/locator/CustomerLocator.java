package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class CustomerLocator extends BaseLocator {
    @Getter
    public static CustomerLocator instance = new CustomerLocator();

    private CustomerLocator() {
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

    /*Customer List*/
    String btnAddCustomerPage = "//button[@testek='btn-add']";
}
