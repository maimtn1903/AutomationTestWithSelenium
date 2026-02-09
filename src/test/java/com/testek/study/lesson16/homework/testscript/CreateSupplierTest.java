package com.testek.study.lesson16.homework.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.study.lesson16.homework.page.pages.HomePage;
import com.testek.study.lesson16.homework.page.pages.SupplierPage;
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
        supplierPage = homePage.gotoSupplierPage();
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {
            AuthorType.Vincent}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating a new supplier")
    public void TK_CreateSupplier_001_Valid() {
        supplierPage.verifySupplierPageDisplay()
                .clickToCreateNewSupplier()
                .fillSupplierInformation()
                .clickToAddMoreSupplier()
                .verifySupplierCreation()
                .goToSearchSupplier()
                .verifySearchSupplierInformation();
    }
}
