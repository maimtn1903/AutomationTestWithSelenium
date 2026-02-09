package com.testek.projects.common;

import com.testek.consts.FrameConst;
import com.testek.consts.FrameConst.LogType;
import com.testek.controller.WebUI;
import com.testek.driver.DriverManager;
import com.testek.consts.ProjectConst;
import com.testek.finalExam.pages.CategoryPg;
import com.testek.finalExam.pages.CustomerPg;
import com.testek.projects.pages.pages.CategoryPage;
import com.testek.projects.pages.pages.CustomerPage;
import com.testek.projects.pages.pages.ProductPage;
import com.testek.projects.pages.pages.SupplierPage;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static com.testek.report.ReportConfig.*;

/**
 * Create a base methods used for subpage to interact with elements
 */
@Getter
@Setter
@Slf4j
public class BasePage extends WebUI {
    public WebDriver webDriver;

    /**
     * Initial a new instance
     */
    public BasePage() {
        webDriver = DriverManager.getDriver();
    }

    //region Redirect to Page

    protected String getRandomPhone() {
        Random random = new Random();

        // Đầu số VN phổ biến
        String[] prefixes = {"03", "05", "07", "08", "09"};
        String prefix = prefixes[random.nextInt(prefixes.length)];

        // Sinh 8 số ngẫu nhiên còn lại
        int suffix = 10000000 + random.nextInt(90000000);

        return prefix + suffix;
    }

    /**
     * Go to specific URL
     *
     * @param URL       : URL Page
     * @param pageTitle : Page title
     */
    protected void goToSpecificURL(String URL, String pageTitle) {
        goToURL(URL);
        assertTrueCondition(null, verifyPageUrl(URL), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, String.format("Verify the '%s' page", pageTitle));
        String msg = BOLD_START + Icon.ICON_NAVIGATE_RIGHT + " Go to URL : " + BOLD_END + DriverManager.getDriver().getCurrentUrl();
        addReportInfo(LogType.INFO, msg, null, null);
    }

    /**
     * Access the 'Product' page
     */
    @Step("Go to 'Product' Page")
    public ProductPage gotoProductPage() {
        ProjectConst.ModuleURL module = ProjectConst.ModuleURL.PRODUCT;
        goToSpecificURL(module.getPath(), module.getName());
        return new ProductPage();
    }

    //endregion
    @Step("Go to 'Customer' Page")
    public CustomerPg gotoCustomerPg() {
        ProjectConst.ModuleURL module = ProjectConst.ModuleURL.CUSTOMER;
        goToSpecificURL(module.getPath(), module.getName());
        return new CustomerPg();
    }

    @Step("Go to 'Customer' Page")
    public CustomerPage gotoCustomerPage() {
        ProjectConst.ModuleURL module = ProjectConst.ModuleURL.CUSTOMER;
        goToSpecificURL(module.getPath(), module.getName());
        return new CustomerPage();
    }

    @Step("Go to 'Supplier' Page")
    public SupplierPage gotoSupplierPage() {
        ProjectConst.ModuleURL module = ProjectConst.ModuleURL.SUPPLIER;
        goToSpecificURL(module.getPath(), module.getName());
        return new SupplierPage();
    }

    @Step("Go to 'Category' Page")
    public CategoryPage gotoCategoryPage() {
        ProjectConst.ModuleURL module = ProjectConst.ModuleURL.CATEGORY;
        goToSpecificURL(module.getPath(), module.getName());
        return new CategoryPage();
    }

    @Step("Go to 'Category' Page")
    public CategoryPg gotoCategoryPg() {
        ProjectConst.ModuleURL module = ProjectConst.ModuleURL.CATEGORY;
        goToSpecificURL(module.getPath(), module.getName());
        return new CategoryPg();
    }
}
