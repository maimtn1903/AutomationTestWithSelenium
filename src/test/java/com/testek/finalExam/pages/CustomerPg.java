package com.testek.finalExam.pages;

import com.testek.consts.FrameConst;
import com.testek.finalExam.objects.CustomerObj;
import com.testek.projects.common.BasePage;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.pages.objects.CustomerObjects;
import com.testek.projects.pages.pages.CategoryPage;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Objects;

public class CustomerPg extends BasePage {
    private final CustomerObj customerObj;

    public CustomerPg() {
        super();
        PageFactory.initElements(webDriver, this);
        customerObj = CustomerObj.getInstance();
    }

    public CustomerPg clickToCreateCustomerPageBtn() {
        customerObj.clickToAddCustomerBtn();
        return this;
    }

    public void verifyAddCustomerPageDisplay() {
        WebElement addCustomerMenuEle = waitForElementVisible(customerObj.findBtnCustomerMenu());
        assertTrueCondition(addCustomerMenuEle, Objects.nonNull(addCustomerMenuEle), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify Add Customer page is displayed");
    }

    public CustomerPg fillCustomerInfo(CreateCustomerModel model) {
        long currentTimeMillis = System.nanoTime();
        model.getName().setValue(model.getName().getValue() + currentTimeMillis);
        model.getEmail().setValue(model.getEmail().getValue() + currentTimeMillis);
        model.getPhone().setValue(model.getPhone().getValue() + currentTimeMillis);

        customerObj.inputCustomerName(model.getName().getValue())
                .inputCustomerPhone(model.getPhone().getValue())
                .inputCustomerEmail(model.getEmail().getValue())
                .inputCustomerContact(model.getContact().getValue())
                .inputCustomerCountry(model.getCountry().getValue())
                .inputCustomerCity(model.getCity().getValue())
                .inputCustomerAddress(model.getAddress().getValue())
                .inputCustomerPostalCode(model.getPostalCode().getValue());
        return this;
    }

    public CustomerPg fillCustomerSearch(String value) {
        customerObj.inputTxtKeyword(value);
        return this;
    }

    public CustomerPg clickToSearchCustomer() {
        customerObj.clickBtnSearch();
        return this;
    }

    // Verify the customer page display
    public void verifyCustomerPageDisplay() {
        WebElement element = waitForElementVisible(customerObj.findBtnAddCustomerPage());
        assertTrueCondition(element, Objects.nonNull(element), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Customer page is displayed");
    }

    //Verify the customer creation
    public void verifyCustomerCreation(CreateCustomerModel model) {
        customerObj.verifySuccessMessageDisplayed();

        String inputtedCustomerName = model.getName().getValue();
        String inputtedCustomerPhone = model.getPhone().getValue();
        String inputtedCustomerEmail = model.getEmail().getValue();
        WebElement customerCode = customerObj.findTxtCustomerCode();
        assertTrueCondition(customerCode, Objects.nonNull(customerCode), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify customer code is created after add customer successfully");
        WebElement errorMessage = customerObj.findTxtErrorMessage();
        String resultText = getValueOfElement(errorMessage);
        JSONObject newCustomerJson = new JSONObject(resultText);
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("id"), getValueOfElement(customerCode), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer code matches the generated value");
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("name"), inputtedCustomerName.toUpperCase(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer name matches the input value");
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("phoneNum"), inputtedCustomerPhone, FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer phone matches the input value");
        assertEqualCondition(errorMessage, newCustomerJson.getJSONObject("data").get("email"), inputtedCustomerEmail, FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the customer email matches the input value");
    }

    public String getCustomerName() {
        customerObj.verifySuccessMessageDisplayed();

        WebElement customerIdEle = customerObj.findTxtCustomerCode();
        assertTrueCondition(customerIdEle, Objects.nonNull(customerIdEle), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Customer ID is displayed after creating a Customer");

        WebElement customerResultEle = customerObj.findTxtErrorMessage();
        String resultText = getValueOfElement(customerResultEle);
        JSONObject customerJson = new JSONObject(resultText);

        return customerJson.getJSONObject("data").get("name").toString();
    }

    public void verifyCreateCustomerFailed(String phone) {

        boolean isSuccess = customerObj.isSuccessMessageDisplayed();
        boolean isError = customerObj.isErrorMessageDisplayed();

        // ĐÚNG: có error, không success
        if (isError && !isSuccess) {
            Assert.assertTrue(true,
                    "Create customer failed as expected with invalid phone: " + phone);
        }
        // BUG: invalid nhưng vẫn success
        else if (isSuccess) {
            Assert.fail(
                    "BUG: Customer created SUCCESSFULLY with INVALID phone: " + phone);
        }
        // Trường hợp bất thường
        else {
            Assert.fail(
                    "UNEXPECTED: No success & no error message with invalid phone: " + phone);
        }
    }
}
