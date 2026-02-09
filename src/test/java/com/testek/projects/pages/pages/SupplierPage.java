package com.testek.projects.pages.pages;

import com.testek.consts.FrameConst;
import com.testek.projects.common.BasePage;
import com.testek.projects.dataprovider.model.CreateProductModel;
import com.testek.projects.dataprovider.model.CreateSupplierModel;
import com.testek.projects.pages.objects.ProductObjects;
import com.testek.projects.pages.objects.SupplierObjects;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static com.testek.utils.FakerUtils.getRandomPrice;
import static com.testek.utils.FakerUtils.getRandomQuantity;

public class SupplierPage extends BasePage {
    private final SupplierObjects supplierObjects;

    public SupplierPage() {
        super();
        PageFactory.initElements(webDriver, this);
        supplierObjects = SupplierObjects.getInstance();
    }

    public SupplierPage clickToCreatSupplier() {
        supplierObjects.clickToAddSupplierBtn();
        return this;
    }

    //region Integration Functions
    public SupplierPage fillSSupplierInfo(CreateSupplierModel createSupplierModel) {
        long currentTimeMillis = System.nanoTime();
        createSupplierModel.getUserName().setValue(createSupplierModel.getUserName().getValue() + currentTimeMillis);
        createSupplierModel.getPhone().setValue(getRandomPhone());
        supplierObjects.inputSupName(createSupplierModel.getUserName().getValue())
                .inputSupPhone(createSupplierModel.getPhone().getValue())
                .inputSupContact(createSupplierModel.getContact().getValue())
                .inputSupCountry(createSupplierModel.getCountry().getValue())
                .inputSupCity(createSupplierModel.getCity().getValue())
                .inputSupAddress(createSupplierModel.getAddress().getValue())
                .inputSupPostalCode(createSupplierModel.getPostalCode().getValue());
        return this;
    }

    // Verify the supplier page display
    public void verifySupplierPageDisplay() {
        WebElement element = waitForElementVisible(supplierObjects.findBtnCreateSupplier());
        assertTrueCondition(element, Objects.nonNull(element), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Supplier page is displayed");
    }

    //Verify the supplier creation
    public void verifySupplierCreation() {
        supplierObjects.verifySuccessMessageDisplayed();

        WebElement supplierIdEle = supplierObjects.findTxtSupplierCode();
        assertTrueCondition(supplierIdEle, Objects.nonNull(supplierIdEle), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the supplier ID is displayed after creating a supplier");

        WebElement supplierResultEle = supplierObjects.findTxtErrorMessage();
        String resultText = getValueOfElement(supplierResultEle);
        JSONObject supplierJson = new JSONObject(resultText);
        assertEqualCondition(supplierResultEle, supplierJson.getJSONObject("data").get("id"), getValueOfElement(supplierIdEle),
                FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the supplier code matches the input value");
    }
}