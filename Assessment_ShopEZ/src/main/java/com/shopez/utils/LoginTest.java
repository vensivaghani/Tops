package com.shopez.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import assestment.ShopEZ_Automation.LoginPage;

public class LoginTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/LoginReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setup() {

       
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogin() {

        test = extent.createTest("Login Test");

        try {
            LoginPage loginPage = new LoginPage(driver);

          
            loginPage.login("standard_user", "secret_sauce");
            test.info("Entered username and password");

            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals(actualUrl, expectedUrl);

            test.pass("Login Successful");

        } catch (Exception e) {
            test.fail("Test Failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}