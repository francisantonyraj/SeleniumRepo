package com.test.scenarios;

import com.test.model.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario_05 {
    private LoginPage loginPage = new LoginPage();
    private WebDriver webDriver;

    @BeforeClass
    public void setup() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() throws InterruptedException {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void close() {
        webDriver.quit();
    }

    @Test
    public void testCase01() {
        loginPage.setPageHeader(findElement(webDriver, "//*[text()='Login']").isDisplayed());
        loginPage.setPasswordLabel(findElement(webDriver, "//*[text()='Username']").isDisplayed());
        loginPage.setUsernameLabel(findElement(webDriver, "//*[text()='Password']").isDisplayed());

        Assert.assertEquals(true, loginPage.isPageHeader());
        Assert.assertEquals(true, loginPage.isUsernameLabel());
        Assert.assertEquals(true, loginPage.isPasswordLabel());
    }

    public WebElement findElement(WebDriver webDriver, String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }
}
