package com.testek.study.lesson16.homework.page.pages;

import com.testek.consts.FrameConst;
import com.testek.projects.common.BasePage;
import com.testek.study.lesson16.homework.page.objects.SupplierObjects;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class SupplierPage extends BasePage {

    private static final String YOUR_NAME = "Testekvn";
    private final SupplierObjects supplierObjects;

    public SupplierPage() {
        super();
        PageFactory.initElements(webDriver, this);
        supplierObjects = SupplierObjects.getInstance();
    }

    public SupplierPage verifySupplierPageDisplay() {
        assertTrueCondition(supplierObjects.findBtnAddEle(),
                Objects.nonNull(supplierObjects.findBtnAddEle()),
                FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the supplier page is displayed");
        return this;
    }

    public SupplierPage clickToCreateNewSupplier() {
        supplierObjects.clickAddButton();
        return this;
    }

    public SupplierPage fillSupplierInformation(String name, String phone,
                                                String contact, String country, String city, String address, String postalCode) {
        supplierObjects.inputCreateSupplierName(name);
        supplierObjects.inputCreateSupplierPhone(phone);
        supplierObjects.inputCreateSupplierContact(contact);
        supplierObjects.inputCreateSupplierAddress(address);
        supplierObjects.inputCreateSupplierCity(city);
        supplierObjects.inputCreateSupplierZip(postalCode);
        supplierObjects.inputCreateSupplierCountry(country);
        return this;
    }

    public SupplierPage fillSupplierInformation() {
        String name = YOUR_NAME + System.currentTimeMillis();
        String phone = "04" + System.currentTimeMillis();
        String contact = "Contact" + System.currentTimeMillis();
        String country = "Vietnam";
        String city = "Hanoi";
        String address = System.currentTimeMillis() + " Test Street";
        String postalCode = "PC" + System.currentTimeMillis();
        return fillSupplierInformation(name, phone, contact, country, city, address, postalCode);
    }

    public SupplierPage clickToAddMoreSupplier() {
        supplierObjects.clickAddMoreButton();
        return this;
    }

    public SupplierPage verifySupplierCreation() {
        // Verify success message
        assertTrueCondition(supplierObjects.findPopUpAddProductResultEle(),
                supplierObjects.findPopUpAddProductResultEle().isDisplayed(),
                FrameConst.FailureHandling.CONTINUE_ON_FAILURE,
                "Verify the success message is displayed after adding a supplier");
        //Verify name message
        assertEqualCondition(supplierObjects.findPopUpAddProductResultEle(), getTextElement(supplierObjects.findPopUpAddProductResultEle()),
                "Thêm nhà cung cấp thành công", FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify name message");
        System.out.println("Name message : " + getTextElement(supplierObjects.findPopUpAddProductResultEle()));
        waitForElementInvisible(supplierObjects.findPopUpAddProductResultEle());
        return this;
    }

    public SupplierPage goToSearchSupplier() {
        supplierObjects.clickSearchSupplierButton();
        return this;
    }

    public SupplierPage verifySearchSupplierInformation() {

        return this;
    }

    /**
     * Verify the order creation
     */
    public SupplierPage verifyCreatSupplierCreation() {
        // Verify success message
        assertTrueCondition(supplierObjects.findPopUpAddProductResultEle(), supplierObjects.findPopUpAddProductResultEle().isDisplayed(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the success message is displayed after adding a Order");
        System.out.println("Name message : " + getTextElement(supplierObjects.findPopUpAddProductResultEle()));
        waitForElementInvisible(supplierObjects.findPopUpAddProductResultEle());
        return this;
    }
}
