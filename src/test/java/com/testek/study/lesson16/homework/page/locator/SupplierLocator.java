package com.testek.study.lesson16.homework.page.locator;

import lombok.Getter;

public class SupplierLocator extends BaseLocator {
    public static final String NAVBAR_SUPPLIER_LABEL_XPATH = "//div[@testek='the-navbar']//div[text()='Nhà cung cấp']";
    public static final String CREATE_SUPPLIER_NAME_ID = "ID|form_item_supName";
    public static final String CREATE_SUPPLIER_PHONE_ID = "ID|form_item_supPhone";
    public static final String CREATE_SUPPLIER_CONTACT_ID = "ID|form_item_supContactName";
    public static final String CREATE_SUPPLIER_ADDRESS_ID = "ID|form_item_supAddress";
    public static final String CREATE_SUPPLIER_CITY_ID = "ID|form_item_supCity";
    public static final String CREATE_SUPPLIER_ZIP_ID = "ID|form_item_supPostalCode";
    public static final String CREATE_SUPPLIER_COUNTRY_ID = "ID|form_item_supCountry";
    @Getter
    public static SupplierLocator instance = new SupplierLocator();
    private SupplierLocator() {
    }
}
