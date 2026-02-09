package com.testek.projects.pages.pages;

import com.testek.consts.FrameConst;
import com.testek.projects.common.BasePage;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.pages.objects.CustomerObjects;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class CustomerPage extends BasePage {
    private final CustomerObjects customerObjects;

    public CustomerPage() {
        super();
        PageFactory.initElements(webDriver, this);
        customerObjects = CustomerObjects.getInstance();
    }

    public CustomerPage clickToCreateCustomerPageBtn() {
        customerObjects.clickToAddCustomerBtn();
        return this;
    }

    public void verifyAddCustomerPageDisplay() {
        WebElement addCustomerMenuEle = waitForElementVisible(customerObjects.findBtnCustomerMenu());
        assertTrueCondition(addCustomerMenuEle, Objects.nonNull(addCustomerMenuEle), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify Add Customer page is displayed");
    }

    public CustomerPage fillCustomerInfo(CreateCustomerModel model) {
        long currentTimeMillis = System.nanoTime();
        model.getName().setValue(model.getName().getValue() + currentTimeMillis);
        model.getEmail().setValue(model.getEmail().getValue() + currentTimeMillis);

        customerObjects.inputCustomerName(model.getName().getValue())
                .inputCustomerPhone(model.getPhone().getValue())
                .inputCustomerEmail(model.getEmail().getValue())
                .inputCustomerContact(model.getContact().getValue())
                .inputCustomerCountry(model.getCountry().getValue())
                .inputCustomerCity(model.getCity().getValue())
                .inputCustomerAddress(model.getAddress().getValue())
                .inputCustomerPostalCode(model.getPostalCode().getValue());
        return this;
    }

    // Verify the customer page display
    public void verifyCustomerPageDisplay() {
        WebElement element = waitForElementVisible(customerObjects.findBtnAddCustomerPage());
        assertTrueCondition(element, Objects.nonNull(element), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Customer page is displayed");
    }

    //Verify the product creation
    public void verifyCustomerCreation(CreateCustomerModel model) {
        customerObjects.verifySuccessMessageDisplayed();

        String inputtedCustomerName = model.getName().getValue();
        String inputtedCustomerPhone = model.getPhone().getValue();
        String inputtedCustomerEmail = model.getEmail().getValue();
        WebElement customerCode = customerObjects.findTxtCustomerCode();
        assertTrueCondition(customerCode, Objects.nonNull(customerCode), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify customer code is created after add customer successfully");
        WebElement errorMessage = customerObjects.findTxtErrorMessage();
        String resultText = getValueOfElement(errorMessage);
        JSONObject newCustomerJson = new JSONObject(resultText);
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("id"), getValueOfElement(customerCode), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer code matches the generated value");
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("name"), inputtedCustomerName.toUpperCase(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer name matches the input value");
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("phoneNum"), inputtedCustomerPhone, FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer phone matches the input value");
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("email"), inputtedCustomerEmail, FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer email matches the input value");
    }
}
