package com.opencart.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static WebDriver getDriver(String browser) {

        if (driver.get() == null) {

            if (browser.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());

            } else if (browser.equalsIgnoreCase("edge")) {

                driver.set(new EdgeDriver());

            } else if (browser.equalsIgnoreCase("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());

            } else {

                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
            }

            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();
        }
    }
}