package com.opencart.tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.opencart.base.BaseTest;
import com.opencart.utilities.ExtentReportUtility;
import com.opencart.utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    @Override
    public void onStart(org.testng.ITestContext context) {

        ExtentReportUtility.setupReport();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReportUtility.startTest(
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        ExtentReportUtility.logPass(
                testName + " completed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    	BaseTest test = (BaseTest) result.getInstance();

        String path = ScreenshotUtility.captureScreenshot(
                test.getDriver(),
                result.getName());

        ExtentReportUtility.logFail(
                "Test Failed");

        ExtentReportUtility.attachScreenshot(path);
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        ExtentReportUtility.flushReport();
    }
}