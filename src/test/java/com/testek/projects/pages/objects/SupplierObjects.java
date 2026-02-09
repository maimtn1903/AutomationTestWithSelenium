package com.testek.projects.pages.objects;

import com.testek.projects.pages.locator.SupplierLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Getter
public class SupplierObjects extends BaseObjects {
    @Getter
    public static SupplierObjects instance = new SupplierObjects();

    private final SupplierLocator supplierLocator;

    private SupplierObjects() {
        supplierLocator = SupplierLocator.getInstance();
    }

    public WebElement findBtnCreateSupplier() {
        return findWebElement(supplierLocator.getBtnAddSupplierPage());
    }

    public WebElement findTxtSupName() {
        return findWebElement(supplierLocator.getTxtSupName());
    }

    public WebElement findTxtSupPhone() {
        return findWebElement(supplierLocator.getTxtSupPhone());
    }

    public WebElement findTxtSupContact() {
        return findWebElement(supplierLocator.getTxtSupContact());
    }

    public WebElement findTxtSupCountry() {
        return findWebElement(supplierLocator.getTxtSupCountry());
    }

    public WebElement findTxtSupCity() {
        return findWebElement(supplierLocator.getTxtSupCity());
    }

    public WebElement findTxtSupAddress() {
        return findWebElement(supplierLocator.getTxtSupAddress());
    }

    public WebElement findTxtSupPostalCode() {
        return findWebElement(supplierLocator.getTxtSupPostalCode());
    }

    public WebElement findBtnAddSupplier() {
        return findWebElement(supplierLocator.getBtnAddSupplier());
    }

    public WebElement findBtnAddMoreSupplier() {
        return findWebElement(supplierLocator.getBtnAddMoreSupplier());
    }

    public WebElement findPopupAddSupplierResult() {
        return findWebElement(supplierLocator.getPopupAddSupplierResult());
    }

    public WebElement findTxtSupplierCode() {
        return findWebElement(supplierLocator.getTxtSupplierCode());
    }

    public WebElement findTxtErrorMessage() {
        return findWebElement(supplierLocator.getTxtErrorMessage());
    }

    public WebElement findBtnCustomerMenu() {
        return findWebElement(supplierLocator.getBtnCustomerMenu());
    }

    public SupplierObjects inputSupName(String supplierName) {
        inputText(findTxtSupName(), "Supplier Name", supplierName);
        return this;
    }

    public SupplierObjects inputSupPhone(String supplierPhone) {
        inputText(findTxtSupPhone(), "Supplier Phone", supplierPhone);
        return this;
    }

    public SupplierObjects inputSupContact(String supplierContact) {
        inputText(findTxtSupContact(), "Supplier Contact", supplierContact);
        return this;
    }

    public SupplierObjects inputSupCountry(String supplierCountry) {
        inputText(findTxtSupCountry(), "Supplier Country", supplierCountry);
        return this;
    }

    public SupplierObjects inputSupCity(String supplierCity) {
        inputText(findTxtSupCity(), "Supplier City", supplierCity);
        return this;
    }

    public SupplierObjects inputSupAddress(String supplierAddress) {
        inputText(findTxtSupAddress(), "Supplier Address", supplierAddress);
        return this;
    }

    public SupplierObjects inputSupPostalCode(String supplierPostalCode) {
        inputText(findTxtSupPostalCode(), "Supplier PostalCode", supplierPostalCode);
        return this;
    }

    public SupplierObjects clickToAddSupplierBtn() {
        clickTo(findBtnAddSupplier(), "Add supplier button");
        return this;
    }

    public void verifySuccessMessageDisplayed() {
        WebElement successMessageEle = findPopupAddSupplierResult();
        Assert.assertTrue(successMessageEle.isDisplayed(), "Success message popup is NOT displayed");
    }
}
