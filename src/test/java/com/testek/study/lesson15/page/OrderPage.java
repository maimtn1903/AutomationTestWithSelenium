package com.testek.study.lesson15.page;

import com.testek.study.lesson15.object.OrderObject;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

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

    // fill info for creating order
    public void fillOrderInfo(HashMap<String, Object> data) {
        String customer = (String) data.get("customer");
        String phone = (String) data.get("phone");
        String email = (String) data.get("email");
        String shippingAddress = (String) data.get("address");
        String employee = (String) data.get("employee");

        fillOrderInfo(customer, phone, shippingAddress, email, shippingAddress,  employee);
    }

    public void verifyCreateOrderSuccess() {
    }
}
