package com.testek.projects.pages.objects;

import com.testek.projects.pages.locator.CategoryLocator;
import com.testek.projects.pages.locator.SupplierLocator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Getter
public class CategoryObjects extends BaseObjects {
    @Getter
    public static CategoryObjects instance = new CategoryObjects();

    private final CategoryLocator categoryLocator;

    private CategoryObjects() {
        categoryLocator = CategoryLocator.getInstance();
    }

    public WebElement findBtnCreateCategory() {
        return findWebElement(categoryLocator.getBtnAddCategoryPage());
    }

    public WebElement findTxtName() {
        return findWebElement(categoryLocator.getTxtName());
    }

    public WebElement findCategoryForm() {
        return findWebElement(categoryLocator.getFormItemStatus());
    }

    public WebElement findTxtStatus() {
        return findWebElement(categoryLocator.getTxtStatus());
    }

    public WebElement findTxtDescription() {
        return findWebElement(categoryLocator.getTxtDescription());
    }

    public WebElement findBtnAddCategory() {
        return findWebElement(categoryLocator.getBtnAddCategory());
    }

    public WebElement findBtnAddMoreCategory() {
        return findWebElement(categoryLocator.getBtnAddMoreCategory());
    }

    public WebElement findBtnAddCategoryPage() {
        return findWebElement(categoryLocator.getBtnAddCategoryPage());
    }

    public WebElement findPopupAddCategoryResult() {
        return findWebElement(categoryLocator.getPopupAddCategoryResult());
    }

    public WebElement findTxtKeyword() {
        return findWebElement(categoryLocator.getTxtKeyword());
    }

    public WebElement findTxtCategoryCode() {
        return findWebElement(categoryLocator.getTxtCategoryCode());
    }

    public WebElement findTxtErrorMessage() {
        return findWebElement(categoryLocator.getTxtErrorMessage());
    }

    public WebElement findBtnSearch() {
        return findWebElement(categoryLocator.getBtnSearch());
    }

    public WebElement findBtnYes() {
        return findWebElement(categoryLocator.getBtnYes());
    }

    public CategoryObjects inputName(String categoryName) {
        inputText(findTxtName(), "Category Name", categoryName);
        return this;
    }

    public CategoryObjects inputStatus(String categoryStatus) {
        inputText(findTxtStatus(), "Category Status", categoryStatus);
        return this;
    }

    public CategoryObjects inputDescription(String categoryDescription) {
        inputText(findTxtDescription(), "Category Description", categoryDescription);
        return this;
    }

    public CategoryObjects inputTxtKeyword(String categoryKeyword) {
        inputText(findTxtKeyword(), "Category keyword", categoryKeyword);
        return this;
    }

    public CategoryObjects clickBtnSearch() {
        clickTo(findBtnSearch(), "Search Category button");
        return this;
    }

    public CategoryObjects clickBtnYes() {
        clickTo(findBtnYes(), "Yes button");
        return this;
    }

    public CategoryObjects clickToAddCategoryBtn() {
        clickTo(findBtnAddCategory(), "Add Category button");
        return this;
    }

    public void verifySuccessMessageDisplayed() {
        WebElement successMessageEle = findPopupAddCategoryResult();
        Assert.assertTrue(successMessageEle.isDisplayed(), "Success message popup is NOT displayed");
    }

    public CategoryObjects selectStatus(String expRowContent) {
        return selectDropdownContent(findCategoryForm(), expRowContent, "Category");
    }

    public CategoryObjects selectEdit(String categoryName) {
        return editCategory(categoryName);
    }

    public CategoryObjects selectDelete(String categoryName) {
        return deleteCategory(categoryName);
    }

    private CategoryObjects selectDropdownContent(WebElement element, String expRowContent, String title) {
        clickElementViaJs(element, "Select " + title);
        inputText(element, title, expRowContent);

        clickTo(findDropContent(expRowContent), "Select " + title + " Type");
        return this;
    }

    private CategoryObjects editCategory(String categoryName) {
        clickTo(findBtnEditCategory(categoryName), "Select edit button");
        return this;
    }

    private CategoryObjects deleteCategory(String categoryName) {
        clickTo(findBtnDeleteCategory(categoryName), "Select delete button");
        return this;
    }


    public WebElement findDropContent(String type) {
        return waitForElementVisible(By.xpath(String.format(categoryLocator.getLblRowContent(), type)));
    }

    public WebElement findBtnEditCategory(String name) {
        return waitForElementVisible(By.xpath(String.format(categoryLocator.getBtnEditCategory(), name)));
    }

    public WebElement findBtnDeleteCategory(String name) {
        return waitForElementVisible(By.xpath(String.format(categoryLocator.getBtnDeleteCategory(), name)));
    }

    public WebElement findCategorySearch() {
        return findWebElement(categoryLocator.getTxtSearch());
    }

    public CategoryObjects inputCategorySearch(String categorySearch) {
        inputText(findCategorySearch(), "Category Search", categorySearch);
        return this;
    }
}
