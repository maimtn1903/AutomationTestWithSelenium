package com.testek.projects.pages.locator;

import lombok.Getter;
import lombok.Setter;

@Getter

public class SupplierLocator extends BaseLocator {
    @Getter
    public static SupplierLocator instance = new SupplierLocator();

    private SupplierLocator() {
    }

    /* Create Supplier */
    String txtSupName = "ID|form_item_supName";
    String txtSupPhone = "ID|form_item_supPhone";
    String txtSupContact = "ID|form_item_supContactName";
    String txtSupCountry = "ID|form_item_supCountry";
    String txtSupCity = "ID|form_item_supCity";
    String txtSupAddress = "ID|form_item_supAddress";
    String txtSupPostalCode = "ID|form_item_supPostalCode";
    String btnAddSupplier = "//button[@testek='btn-add']";
    String btnAddMoreSupplier = "//button[@testek='btn-add-more']";
    String popupAddSupplierResult = "//div[contains(@class,'ant-message-success')]";
    String txtSupplierCode = "//div[@class='footer']/descendant::input[@placeholder='Mã nhà cung cấp']";
    String txtErrorMessage = "//div[@class='footer']/descendant::textarea";
    String btnCustomerMenu = "//div[@class='menus']/descendant::span[normalize-space()='Nhà cung cấp']/parent::button";

    /*Supplier List*/
    String btnAddSupplierPage = "//button[@testek='btn-add']";
}

