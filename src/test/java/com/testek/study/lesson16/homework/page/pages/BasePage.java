package com.testek.study.lesson16.homework.page.pages;

import com.testek.consts.FrameConst;
import com.testek.consts.ProjectConst;
import com.testek.controller.WebUI;
import com.testek.driver.DriverManager;
import com.testek.projects.pages.pages.ProductPage;
import com.testek.report.ReportConfig;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static com.testek.report.ReportConfig.BOLD_END;
import static com.testek.report.ReportConfig.BOLD_START;

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

    /**
     * Go to specific URL
     *
     * @param URL       : URL Page
     * @param pageTitle : Page title
     */
    protected void goToSpecificURL(String URL, String pageTitle) {
        goToURL(URL);
        assertTrueCondition(null, verifyPageUrl(URL), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, String.format("Verify the '%s' page", pageTitle));
        String msg = BOLD_START + ReportConfig.Icon.ICON_NAVIGATE_RIGHT + " Go to URL : " + BOLD_END + DriverManager.getDriver().getCurrentUrl();
        addReportInfo(FrameConst.LogType.INFO, msg, null, null);
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

    /**
     * Access the 'Supplier' page
     */
    @Step("Go to 'Supplier' Page")
    public SupplierPage gotoSupplierPage() {
        ProjectConst.ModuleURL module = ProjectConst.ModuleURL.SUPPLIER;
        goToSpecificURL(module.getPath(), module.getName());
        return new SupplierPage();
    }
}