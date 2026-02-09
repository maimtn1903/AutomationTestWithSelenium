package com.testek.finalExam.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.finalExam.pages.CategoryPg;
import com.testek.projects.common.TestBase;
import com.testek.projects.pages.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class exportCategory extends TestBase {
    CategoryPg categoryPg;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        categoryPg = homePage.gotoCategoryPg();  // Access to Category page
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.MAIMAI}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify the export and print function")
    public void Testek_Export_001_Valid() {
        categoryPg.verifyCategoryPageDisplay()
                .clickExport() //Export
                .clickPrint(); // Print
    }
}
