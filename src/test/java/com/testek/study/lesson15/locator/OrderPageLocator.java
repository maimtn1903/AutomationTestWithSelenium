package com.testek.study.lesson15.locator;

import lombok.Getter;

@Getter
public class OrderPageLocator {

    String menuOrder = "//div[@testek='category-menu']";

    String txtCustomerId = "form_item_customerId";
    String txtPhoneId = "form_item_phoneNum";
    String txtShippingPhoneId = "form_item_shippingPhoneNum";
    String txtEmailId = "form_item_email";
    String txtShippingAddressId = "form_item_shipAddress";
    String chkInvoiceAddress = "//input[@type='checkbox']";
    String txtInvoiceAddressId = "form_item_invoiceAddress";
    String txtEmployeeId = "form_item_employeeId";

    String btnAddOrder = "//button[@testek='btn-add']";

    String lblOrderIdResult = "//input[@placeholder='Mã đơn hàng']";
    String lblDropdownDetail ="//div[@title='%s']";
}
