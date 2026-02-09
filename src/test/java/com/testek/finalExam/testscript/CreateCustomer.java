package com.testek.finalExam.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.finalExam.pages.CustomerPg;
import com.testek.projects.common.TestBase;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.dataprovider.providers.CreateCustomerProvider;
import com.testek.projects.pages.pages.CustomerPage;
import com.testek.projects.pages.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCustomer extends TestBase {
    CustomerPg customerPg;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        customerPg = homePage.gotoCustomerPg(); // Access to Customer page
    }

    //10 khách hàng với SĐT hợp lệ
    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.MAIMAI}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating a new customer", dataProvider = "TK_CreateCustomer_001_Valid", dataProviderClass = CreateCustomerProvider.class)
    public void TK_CreateCustomer_001_Valid(CreateCustomerModel createCustomerModel) {
        customerPg.verifyCustomerPageDisplay(); // Verify customer page
        customerPg.clickToCreateCustomerPageBtn()      // Click button Create Customer
                .fillCustomerInfo(createCustomerModel)
                .clickToCreateCustomerPageBtn();
        // Verify add customer success
        customerPg.verifyCustomerCreation(createCustomerModel); //Verify new customer
        String customerName = customerPg.getCustomerName();

        // Back to customer page
        homePage.gotoCustomerPg();

        // Search
        customerPg.fillCustomerSearch(customerName)
                .clickToSearchCustomer()     //Search
                .verifyCustomerPageDisplay();   //verify thông tin được xuất hiện
    }

    //10 khách hàng với SĐT không hợp lệ
    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.MAIMAI}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating customer with INVALID phone number", dataProvider = "TK_CreateCustomer_002_Invalid", dataProviderClass = CreateCustomerProvider.class)
    public void TK_CreateCustomer_002_Invalid(CreateCustomerModel createCustomerModel) {
        customerPg.verifyCustomerPageDisplay(); // Verify customer page
        customerPg.clickToCreateCustomerPageBtn()      // Click button Create Customer
                .fillCustomerInfo(createCustomerModel)
                .clickToCreateCustomerPageBtn();
        // VERIFY FAILED
        customerPg.verifyCreateCustomerFailed(createCustomerModel.getPhone().getValue());
    }
}
