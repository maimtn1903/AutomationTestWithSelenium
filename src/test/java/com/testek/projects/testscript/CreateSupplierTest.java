package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.dataprovider.model.CreateSupplierModel;
import com.testek.projects.dataprovider.providers.CreateSupplierProvider;
import com.testek.projects.pages.pages.HomePage;
import com.testek.projects.pages.pages.SupplierPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateSupplierTest extends TestBase {
    SupplierPage supplierPage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        supplierPage = homePage.gotoSupplierPage();   // Access to Supplier page
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.MAIMAI}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating a new supplier", dataProvider = "TK_CreateSupplier_001_Valid", dataProviderClass = CreateSupplierProvider.class)
    public void TK_CreateSupplier_001_Valid(CreateSupplierModel createSupplierModel) {
        supplierPage.verifySupplierPageDisplay(); // Verify supplier page hien thi

        supplierPage.clickToCreatSupplier()      // Click button Create supplier
                .fillSSupplierInfo(createSupplierModel)
                .clickToCreatSupplier();

        // Verify add supplier success
        supplierPage.verifySupplierCreation();        // Verify popup success hien thi
    }
}