package com.testek.finalExam.objects;

import com.testek.finalExam.locator.CategoryLoc;
import com.testek.projects.pages.locator.CategoryLocator;
import com.testek.projects.pages.locator.SupplierLocator;
import com.testek.projects.pages.objects.BaseObjects;
import com.testek.projects.pages.objects.CategoryObjects;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Getter
public class CategoryObj extends BaseObjects {
    @Getter
    public static CategoryObj instance = new CategoryObj();

    private final CategoryLoc categoryLoc;

    private CategoryObj() {
        categoryLoc = CategoryLoc.getInstance();
    }

    public WebElement findBtnExportCategory() {
        return findWebElement(categoryLoc.getBtnExport());
    }

    public WebElement findBtnPrintCategory() {
        return findWebElement(categoryLoc.getBtnPrint());
    }

    public CategoryObj clickBtnExport() {
        clickTo(findBtnExportCategory(), "Export Category button");
        return this;
    }

    public CategoryObj clickBtnPrint() {
        clickTo(findBtnPrintCategory(), "Print Category button");
        return this;
    }
}
