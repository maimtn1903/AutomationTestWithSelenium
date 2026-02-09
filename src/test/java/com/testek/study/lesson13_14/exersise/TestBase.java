package com.testek.study.lesson13_14.exersise;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.annotations.*;


@Setter
@Getter
@Slf4j
public class TestBase {
    public TestBase() {
        // Constructor
    }

    @Parameters({"browser"})
    @BeforeSuite
    public void beforeSuite(@Optional("chrome") String browser) {
        // Before Suite
    }

    @BeforeMethod(alwaysRun = true)
    public void addInvocation(ITestResult tr) {
        // Action before test method
    }

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void createDriver(@Optional("chrome") String browser) {
        // Khởi tạo Chrome Driver
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        // Quite Chrome Driver
    }

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {

    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
    }

}
