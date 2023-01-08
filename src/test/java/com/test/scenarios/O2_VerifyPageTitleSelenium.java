package com.test.scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class O2_VerifyPageTitleSelenium {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @BeforeMethod
    public void launch() throws InterruptedException {
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCase01() {
        String title = webDriver.getTitle();
        Assert.assertEquals("OrangeHRM", title);
    }

    @AfterClass
    public void closeApplication() {
        webDriver.close();
    }
}