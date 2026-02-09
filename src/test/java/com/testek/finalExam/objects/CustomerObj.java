package com.testek.finalExam.objects;

import com.testek.finalExam.locator.CustomerLoc;
import com.testek.projects.pages.locator.CustomerLocator;
import com.testek.projects.pages.locator.ProductLocator;
import com.testek.projects.pages.objects.BaseObjects;
import com.testek.projects.pages.objects.CategoryObjects;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Getter
public class CustomerObj extends BaseObjects {
    @Getter
    public static CustomerObj instance = new CustomerObj();

    private final CustomerLoc customerLoc;

    private CustomerObj() {
        customerLoc = CustomerLoc.getInstance();
    }

    public WebElement findBtnAddCustomerPage() {
        return findWebElement(customerLoc.getBtnAddCustomerPage());
    }

    public WebElement findBtnCustomerMenu() {
        return findWebElement(customerLoc.getBtnCustomerMenu());
    }

    public WebElement findTxtCustomerName() {
        return findWebElement(customerLoc.getTxtCustomerName());
    }

    public WebElement findTxtCustomerPhone() {
        return findWebElement(customerLoc.getTxtCustomerPhone());
    }

    public WebElement findTxtCustomerEmail() {
        return findWebElement(customerLoc.getTxtCustomerEmail());
    }

    public WebElement findTxtCustomerContact() {
        return findWebElement(customerLoc.getTxtCustomerContact());
    }

    public WebElement findTxtCustomerCountry() {
        return findWebElement(customerLoc.getTxtCustomerCountry());
    }

    public WebElement findTxtCustomerCity() {
        return findWebElement(customerLoc.getTxtCustomerCity());
    }

    public WebElement findTxtCustomerAddress() {
        return findWebElement(customerLoc.getTxtCustomerAddress());
    }

    public WebElement findTxtCustomerPostalCode() {
        return findWebElement(customerLoc.getTxtCustomerPostalCode());
    }

    public WebElement findBtnAddCustomer() {
        return findWebElement(customerLoc.getBtnAddCustomer());
    }

    public WebElement findBtnSearch() {
        return findWebElement(customerLoc.getBtnSearch());
    }

    public WebElement findBtnAddMoreCustomer() {
        return findWebElement(customerLoc.getBtnAddMoreCustomer());
    }

    public WebElement findTxtKeyword() {
        return findWebElement(customerLoc.getTxtKeyword());
    }

    public WebElement findPopupAddCustomerResult() {
        return findWebElement(customerLoc.getPopupAddCustomerResult());
    }

    public WebElement findTxtCustomerCode() {
        return findWebElement(customerLoc.getTxtCustomerCode());
    }

    public WebElement findTxtErrorMessage() {
        return findWebElement(customerLoc.getTxtErrorMessage());
    }

    public CustomerObj inputCustomerName(String customerName) {
        inputText(findTxtCustomerName(), "Customer Name", customerName);
        return this;
    }

    public CustomerObj inputCustomerPhone(String customerPhone) {
        inputText(findTxtCustomerPhone(), "Customer Phone", customerPhone);
        return this;
    }

    public CustomerObj inputCustomerEmail(String customerEmail) {
        inputText(findTxtCustomerEmail(), "Customer Email", customerEmail);
        return this;
    }

    public CustomerObj inputCustomerContact(String customerContact) {
        inputText(findTxtCustomerContact(), "Customer Email", customerContact);
        return this;
    }

    public CustomerObj inputCustomerCountry(String customerCountry) {
        inputText(findTxtCustomerCountry(), "Customer Country", customerCountry);
        return this;
    }

    public CustomerObj inputCustomerCity(String customerCity) {
        inputText(findTxtCustomerCity(), "Customer Country", customerCity);
        return this;
    }

    public CustomerObj inputCustomerAddress(String customerAddress) {
        inputText(findTxtCustomerAddress(), "Customer Country", customerAddress);
        return this;
    }

    public CustomerObj inputCustomerPostalCode(String customerPostalCode) {
        inputText(findTxtCustomerPostalCode(), "Customer Country", customerPostalCode);
        return this;
    }

    public CustomerObj inputTxtKeyword(String customerKeyword) {
        inputText(findTxtKeyword(), "Customer keyword", customerKeyword);
        return this;
    }

    public CustomerObj clickToAddCustomerBtn() {
        clickTo(findBtnAddCustomer(), "Add customer button");
        return this;
    }

    public CustomerObj clickBtnSearch() {
        clickTo(findBtnSearch(), "Search Customer button");
        return this;
    }

    public void verifySuccessMessageDisplayed() {
        WebElement successMessageEle = findPopupAddCustomerResult();
        Assert.assertTrue(successMessageEle.isDisplayed(), "Success message popup is NOT displayed");
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return findPopupAddCustomerResult().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return findTxtErrorMessage().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}

