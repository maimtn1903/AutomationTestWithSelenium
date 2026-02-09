package com.testek.study.lesson13_14.exersise.page;

import com.testek.study.lesson13_14.exersise.object.OrderObject;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    private OrderObject orderObject;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.orderObject = new OrderObject(webDriver);
    }

    // fill info for creating order
    public void fillOrderInfo(String customer, String phone, String shippingPhone,
                              String email, String shippingAddress, String employee) {
        orderObject.chooseCustomer(customer);
        orderObject.inputPhone(phone);
        orderObject.inputShippingPhone(shippingPhone);
        orderObject.inputEmail(email);
        orderObject.inputShippingAddress(shippingAddress);
        orderObject.inputInvoiceAddress(shippingAddress);
        orderObject.chooseEmployee(employee);

        orderObject.clickAddItemButton();
    }

    public void verifyCreateOrderSuccess() {
    }
}
