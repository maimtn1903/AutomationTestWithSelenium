package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.dataprovider.model.CreateCategoryModel;
import com.testek.projects.dataprovider.model.CreateSupplierModel;
import com.testek.projects.dataprovider.providers.CreateCategoryProvider;
import com.testek.projects.dataprovider.providers.CreateSupplierProvider;
import com.testek.projects.pages.pages.CategoryPage;
import com.testek.projects.pages.pages.HomePage;
import com.testek.projects.pages.pages.SupplierPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCategoryTest extends TestBase {
    CategoryPage categoryPage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        categoryPage = homePage.gotoCategoryPage();   // Access to Category page
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.MAIMAI}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating a new category", dataProvider = "TK_CreateCategory_001_Valid", dataProviderClass = CreateCategoryProvider.class)
    public void TK_CreateCategory_001_Valid(CreateCategoryModel createCategoryModel) {
        categoryPage.verifyCategoryPageDisplay(); // Verify category page hien thi

        categoryPage.clickToCreatCategory()      // Click button Create category
                .fillCategoryInfo(createCategoryModel)
                .clickToCreatCategory();

        // Verify add category success
        categoryPage.verifyCategoryPageDisplay().verifyCategoryCreation();        // Verify popup success hien thi
        String categoryName = categoryPage.getCategoryName();

        // Back to category page
        homePage.gotoCategoryPage();

        // Search -> Edit -> Delete
        categoryPage
                .fillCategorySearch(categoryName)
                .clickToSearchCategory()
                .gotoEditCategory(categoryName)
                .fillCategoryInfoEdit(createCategoryModel)
                .clickToCreatCategory();
        homePage.gotoCategoryPage();
        categoryPage.fillCategorySearch(categoryName).clickToSearchCategory().gotoDeleteCategory(categoryName).clickToYesBtn();

        // Verify delete category success
        categoryPage.verifyCategoryDeleteSuccess();   // Verify popup success hien thi
    }
}

