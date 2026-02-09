package com.testek.finalExam.pages;

import com.testek.consts.FrameConst;
import com.testek.finalExam.objects.CategoryObj;
import com.testek.projects.common.BasePage;
import com.testek.projects.pages.objects.CategoryObjects;
import com.testek.projects.pages.pages.CategoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class CategoryPg extends BasePage {
    private final CategoryObj categoryObj;

    public CategoryPg() {
        super();
        PageFactory.initElements(webDriver, this);
        categoryObj = CategoryObj.getInstance();
    }

    /* Verify the category page display */
    public CategoryPg verifyCategoryPageDisplay() {
        WebElement element = waitForElementVisible(categoryObj.findBtnExportCategory());
        assertTrueCondition(element, Objects.nonNull(element), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify the Category page is displayed");
        return this;
    }

    public CategoryPg clickExport() {
        categoryObj.findBtnExportCategory();
        categoryObj.clickBtnExport();
        return this;
    }

    public CategoryPg clickPrint() {
        categoryObj.findBtnPrintCategory();
        categoryObj.clickBtnPrint();
        return this;
    }
}