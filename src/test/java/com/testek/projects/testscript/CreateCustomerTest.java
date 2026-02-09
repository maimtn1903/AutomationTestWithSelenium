package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.dataprovider.providers.CreateCustomerProvider;
import com.testek.projects.pages.pages.CustomerPage;
import com.testek.projects.pages.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCustomerTest extends TestBase {
    CustomerPage customerPage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        customerPage = homePage.gotoCustomerPage(); // Access to Customer page
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.MAIMAI}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating a new customer", dataProvider = "TK_CreateCustomer_001_Valid", dataProviderClass = CreateCustomerProvider.class)
    public void TK_CreateCustomer_001_Valid(CreateCustomerModel createCustomerModel) {
        customerPage.verifyCustomerPageDisplay(); // Verify customer page
        customerPage.clickToCreateCustomerPageBtn()      // Click button Create Customer
                .fillCustomerInfo(createCustomerModel)
                .clickToCreateCustomerPageBtn();
        // Verify add customer success
        customerPage.verifyCustomerCreation(createCustomerModel); //Verify new customer
    }
}
