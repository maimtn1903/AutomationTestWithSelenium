package com.testek.study.lesson13_14.exersise.object;

import com.testek.study.lesson13_14.exersise.locator.OrderPageLocator;
import com.testek.study.lesson13_14.exersise.page.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
public class OrderObject extends BasePage {
    private OrderPageLocator locator;

    public OrderObject(WebDriver webDriver) {
        super();
        this.locator = new OrderPageLocator();
        this.setWebDriver(webDriver);
    }

    public WebElement findMenuOrderCreation() {
        return findElement(By.xpath(locator.getMenuOrder()));
    }

    public WebElement findCustomer() {
        return findElement(By.id(locator.getTxtCustomerId()));
    }

    public WebElement findPhone() {
        return findElement(By.id(locator.getTxtPhoneId()));
    }

    public WebElement findShippingPhone() {
        return findElement(By.id(locator.getTxtShippingPhoneId()));
    }

    public WebElement findEmail() {
        return findElement(By.id(locator.getTxtEmailId()));
    }

    public WebElement findShippingAddressId() {
        return findElement(By.id(locator.getTxtShippingAddressId()));
    }

    public WebElement findInvoiceAddressCheckbox() {
        return findElement(By.xpath(locator.getChkInvoiceAddress()));
    }

    public WebElement findInvoiceAddress() {
        return findElement(By.id(locator.getTxtInvoiceAddressId()));
    }

    public WebElement findEmployee() {
        return findElement(By.id(locator.getTxtEmployeeId()));
    }

    public WebElement findAddItemButton() {
        return findElement(By.xpath(locator.getBtnAddOrder()));
    }

    public WebElement findOrderResult() {
        return findElement(By.xpath(locator.getLblOrderIdResult()));
    }

    public WebElement findDropDownOption(String value) {
        String dropdownLocator = String.format(locator.getLblDropdownDetail(), value);
        return findElement(By.xpath(dropdownLocator));
    }


    // Actions
    public void chooseCustomer(String customer) {
        inputText(findCustomer(), "Choose Customer", customer, true);
        clickTo(findDropDownOption(customer), "Select " + customer + " from dropdown");
    }

    public void chooseEmployee(String employee) {
        inputText(findEmployee(), "Choose Employee", employee, true);
        clickTo(findDropDownOption(employee), "Select " + employee + " from dropdown");
    }

    public void inputPhone(String phone) {
        inputText(findPhone(), "Phone", phone, true);
    }

    public void inputShippingPhone(String shippingPhone) {
        inputText(findShippingPhone(), "Shipping Phone", shippingPhone, true);
    }

    public void inputEmail(String email) {
        inputText(findEmail(), "Email", email, true);
    }

    public void inputShippingAddress(String address) {
        inputText(findShippingAddressId(), "Shipping Address", address, true);
    }

    public void checkInvoiceAddressCheckbox() {
        clickTo(findInvoiceAddressCheckbox(), "Check Invoice Address Checkbox");
    }

    public void inputInvoiceAddress(String address) {
        inputText(findInvoiceAddress(), "Invoice Address", address, true);
    }

    public void clickAddItemButton() {
        clickTo(findAddItemButton(), "Add Item Button");
    }

    /**
     * Verify that the Menu Order Creation is displayed.
     */
    public void verifyMenuOrderCreationIsDisplayed() {
        assertTrue(findMenuOrderCreation().isDisplayed(), "Menu Order Creation is displayed");
    }


}
