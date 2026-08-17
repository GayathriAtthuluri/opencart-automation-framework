package com.opencart.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void setupReport() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("Reports/ExtentReport.html");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Project", "OpenCart Automation");
        extent.setSystemInfo("Role", "QA Automation Engineer");
        extent.setSystemInfo("Environment", "QA");
    }

    public static void startTest(String testName) {

        test = extent.createTest(testName);
    }

    public static void logPass(String message) {

        test.pass(message);
    }

    public static void logFail(String message) {

        test.fail(message);
    }

    public static void attachScreenshot(String screenshotPath) {

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void flushReport() {

        extent.flush();
    }
}