package com.testek.study.lesson16.homework.page.objects;

import com.testek.study.lesson16.homework.page.locator.SupplierLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

public class SupplierObjects extends BaseObjects {
    @Getter
    public static SupplierObjects instance = new SupplierObjects();

    private SupplierObjects() {
    }

    public WebElement findCreateSupplierName() {
        return findWebElement(SupplierLocator.CREATE_SUPPLIER_NAME_ID);
    }

    public WebElement findCreateSupplierPhone() {
        return findWebElement(SupplierLocator.CREATE_SUPPLIER_PHONE_ID);
    }

    public WebElement findCreateSupplierContact() {
        return findWebElement(SupplierLocator.CREATE_SUPPLIER_CONTACT_ID);
    }

    public WebElement findCreateSupplierAddress() {
        return findWebElement(SupplierLocator.CREATE_SUPPLIER_ADDRESS_ID);
    }

    public WebElement findCreateSupplierCity() {
        return findWebElement(SupplierLocator.CREATE_SUPPLIER_CITY_ID);
    }

    public WebElement findCreateSupplierZip() {
        return findWebElement(SupplierLocator.CREATE_SUPPLIER_ZIP_ID);
    }

    public WebElement findCreateSupplierCountry() {
        return findWebElement(SupplierLocator.CREATE_SUPPLIER_COUNTRY_ID);
    }

    public void inputCreateSupplierName(String name) {
        inputText(findCreateSupplierName(), "Input supplier name", name);
    }

    public void inputCreateSupplierPhone(String phone) {
        inputText(findCreateSupplierPhone(), "Input supplier phone", phone);
    }

    public void inputCreateSupplierContact(String contact) {
        inputText(findCreateSupplierContact(), "Input supplier contact", contact);
    }

    public void inputCreateSupplierAddress(String address) {
        inputText(findCreateSupplierAddress(), "Input supplier address", address);
    }

    public void inputCreateSupplierCity(String city) {
        inputText(findCreateSupplierCity(), "Input supplier city", city);
    }

    public void inputCreateSupplierZip(String zip) {
        inputText(findCreateSupplierZip(), "Input supplier zip", zip);
    }

    public void inputCreateSupplierCountry(String country) {
        inputText(findCreateSupplierCountry(), "Input supplier country", country);
    }

    public WebElement findSearchSupplierBtnAddEle() {
        return findWebElement(SupplierLocator.NAVBAR_SUPPLIER_LABEL_XPATH);
    }

    public void clickSearchSupplierButton(){
        clickTo(findSearchSupplierBtnAddEle());
    }
}
