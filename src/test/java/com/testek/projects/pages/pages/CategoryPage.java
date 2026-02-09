package com.testek.projects.pages.pages;

import com.testek.consts.FrameConst;
import com.testek.projects.common.BasePage;
import com.testek.projects.dataprovider.model.CreateCategoryModel;
import com.testek.projects.dataprovider.model.CreateSupplierModel;
import com.testek.projects.pages.locator.CategoryLocator;
import com.testek.projects.pages.objects.CategoryObjects;
import com.testek.projects.pages.objects.SupplierObjects;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class CategoryPage extends BasePage {
    private final CategoryObjects categoryObjects;

    public CategoryPage() {
        super();
        PageFactory.initElements(webDriver, this);
        categoryObjects = CategoryObjects.getInstance();
    }

    public CategoryPage clickToCreatCategory() {
        categoryObjects.clickToAddCategoryBtn();
        return this;
    }

    public CategoryPage clickToSearchCategory() {
        categoryObjects.clickBtnSearch();
        return this;
    }

    public CategoryPage clickToYesBtn() {
        categoryObjects.clickBtnYes();
        return this;
    }

    //region Integration Functions
    public CategoryPage fillCategoryInfo(CreateCategoryModel model) {
        /* Update the random name & description */
        long currentTimeMillis = System.nanoTime();
        categoryObjects
                .inputName(model.getName().getValue() + currentTimeMillis)
                .selectStatus(model.getStatus().getValue())
                .inputDescription(model.getDescription().getValue() + currentTimeMillis);
        return this;
    }

    public CategoryPage fillCategoryInfoEdit(CreateCategoryModel model) {
        long currentTimeMillis = System.nanoTime();
        categoryObjects
                .selectStatus(model.getStatus().getValue())
                .inputDescription(model.getDescription().getValue() + currentTimeMillis);
        return this;
    }

    public CategoryPage fillCategorySearch(String value) {
        categoryObjects.inputTxtKeyword(value);
        return this;
    }

    /* Verify the category page display */
    public CategoryPage verifyCategoryPageDisplay() {
        WebElement element = waitForElementVisible(categoryObjects.findBtnAddCategoryPage());
        assertTrueCondition(element, Objects.nonNull(element), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Category page is displayed");
        return this;
    }

    //Verify the category creation
    public CategoryPage verifyCategoryCreation() {
        categoryObjects.verifySuccessMessageDisplayed();

        WebElement categoryIdEle = categoryObjects.findTxtCategoryCode();
        assertTrueCondition(categoryIdEle, Objects.nonNull(categoryIdEle), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Category ID is displayed after creating a Category");

        WebElement categoryResultEle = categoryObjects.findTxtErrorMessage();
        String resultText = getValueOfElement(categoryResultEle);
        JSONObject categoryJson = new JSONObject(resultText);
        assertEqualCondition(categoryResultEle, categoryJson.getJSONObject("data").get("id"), getValueOfElement(categoryIdEle),
                FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Category code matches the input value");
        return this;
    }

    public String getCategoryName() {
        categoryObjects.verifySuccessMessageDisplayed();

        WebElement categoryIdEle = categoryObjects.findTxtCategoryCode();
        assertTrueCondition(categoryIdEle, Objects.nonNull(categoryIdEle), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Category ID is displayed after creating a Category");

        WebElement categoryResultEle = categoryObjects.findTxtErrorMessage();
        String resultText = getValueOfElement(categoryResultEle);
        JSONObject categoryJson = new JSONObject(resultText);

        return categoryJson.getJSONObject("data").get("categoryName").toString();
    }

    public CategoryPage gotoEditCategory(String nameCategory) {
        categoryObjects.selectEdit(nameCategory);
        return this;
    }

    public CategoryPage gotoDeleteCategory(String nameCategory) {
        categoryObjects.selectDelete(nameCategory);
        return this;
    }

    public CategoryPage verifyCategoryDeleteSuccess() {
        categoryObjects.verifySuccessMessageDisplayed();
        return this;
    }
}
