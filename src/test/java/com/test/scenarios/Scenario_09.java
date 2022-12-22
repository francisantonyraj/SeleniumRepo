package com.test.scenarios;

import com.relevantcodes.extentreports.ExtentReports;
import com.test.model.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class Scenario_09 {

    private WebDriver webDriver;
    private LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setup() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() throws InterruptedException {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
    }

    @Test
    @Parameters({"xpathValue1", "xpathValue2", "xpathValue3"})
    public void testCase01(String value1, String value2, String value3) {
        loginPage.setPageHeader(findElement(webDriver, value1).isDisplayed());
        loginPage.setPasswordLabel(findElement(webDriver, value2).isDisplayed());
        loginPage.setUsernameLabel(findElement(webDriver, value3).isDisplayed());

        Assert.assertEquals(true, loginPage.isPageHeader());
        Assert.assertEquals(true, loginPage.isUsernameLabel());
        Assert.assertEquals(true, loginPage.isPasswordLabel());
    }

    @AfterMethod
    public void close() {
        webDriver.close();
    }

    @AfterClass
    public void quitDriver() {
        webDriver.quit();
    }

    public WebElement findElement(WebDriver webDriver, String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }
}
