package com.testek.projects.pages.objects;

import com.testek.projects.pages.locator.CustomerLocator;
import com.testek.projects.pages.locator.ProductLocator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Getter
public class CustomerObjects extends BaseObjects {
    @Getter
    public static CustomerObjects instance = new CustomerObjects();

    private final CustomerLocator customerLocator;

    private CustomerObjects() {
        customerLocator = CustomerLocator.getInstance();
    }

    public WebElement findBtnAddCustomerPage() {
        return findWebElement(customerLocator.getBtnAddCustomerPage());
    }

    public WebElement findBtnCustomerMenu() {
        return findWebElement(customerLocator.getBtnCustomerMenu());
    }

    public WebElement findTxtCustomerName() {
        return findWebElement(customerLocator.getTxtCustomerName());
    }

    public WebElement findTxtCustomerPhone() {
        return findWebElement(customerLocator.getTxtCustomerPhone());
    }

    public WebElement findTxtCustomerEmail() {
        return findWebElement(customerLocator.getTxtCustomerEmail());
    }

    public WebElement findTxtCustomerContact() {
        return findWebElement(customerLocator.getTxtCustomerContact());
    }

    public WebElement findTxtCustomerCountry() {
        return findWebElement(customerLocator.getTxtCustomerCountry());
    }

    public WebElement findTxtCustomerCity() {
        return findWebElement(customerLocator.getTxtCustomerCity());
    }

    public WebElement findTxtCustomerAddress() {
        return findWebElement(customerLocator.getTxtCustomerAddress());
    }

    public WebElement findTxtCustomerPostalCode() {
        return findWebElement(customerLocator.getTxtCustomerPostalCode());
    }

    public WebElement findBtnAddCustomer() {
        return findWebElement(customerLocator.getBtnAddCustomer());
    }

    public WebElement findBtnAddMoreCustomer() {
        return findWebElement(customerLocator.getBtnAddMoreCustomer());
    }

    public WebElement findPopupAddCustomerResult() {
        return findWebElement(customerLocator.getPopupAddCustomerResult());
    }

    public WebElement findTxtCustomerCode() {
        return findWebElement(customerLocator.getTxtCustomerCode());
    }

    public WebElement findTxtErrorMessage() {
        return findWebElement(customerLocator.getTxtErrorMessage());
    }

    public CustomerObjects inputCustomerName(String customerName) {
        inputText(findTxtCustomerName(), "Customer Name", customerName);
        return this;
    }

    public CustomerObjects inputCustomerPhone(String customerPhone) {
        inputText(findTxtCustomerPhone(), "Customer Phone", customerPhone);
        return this;
    }

    public CustomerObjects inputCustomerEmail(String customerEmail) {
        inputText(findTxtCustomerEmail(), "Customer Email", customerEmail);
        return this;
    }

    public CustomerObjects inputCustomerContact(String customerContact) {
        inputText(findTxtCustomerContact(), "Customer Email", customerContact);
        return this;
    }

    public CustomerObjects inputCustomerCountry(String customerCountry) {
        inputText(findTxtCustomerCountry(), "Customer Country", customerCountry);
        return this;
    }

    public CustomerObjects inputCustomerCity(String customerCity) {
        inputText(findTxtCustomerCity(), "Customer Country", customerCity);
        return this;
    }

    public CustomerObjects inputCustomerAddress(String customerAddress) {
        inputText(findTxtCustomerAddress(), "Customer Country", customerAddress);
        return this;
    }

    public CustomerObjects inputCustomerPostalCode(String customerPostalCode) {
        inputText(findTxtCustomerPostalCode(), "Customer Country", customerPostalCode);
        return this;
    }

    public CustomerObjects clickToAddCustomerBtn() {
        clickTo(findBtnAddCustomer(), "Add customer button");
        return this;
    }

    public void verifySuccessMessageDisplayed() {
        WebElement successMessageEle = findPopupAddCustomerResult();
        Assert.assertTrue(successMessageEle.isDisplayed(), "Success message popup is NOT displayed");
    }
}
