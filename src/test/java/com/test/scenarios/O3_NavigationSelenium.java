package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class O3_NavigationSelenium {
    private WebDriver webDriver;
    private WebElement webElement;

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
    public void testCase01() throws InterruptedException {
        Thread.sleep(5000);
        webElement = webDriver.findElement(By.xpath("//*[text()='Forgot your password? ']"));
        webElement.click();
        webDriver.navigate().back();
        webDriver.navigate().forward();
    }

    @AfterClass
    public void closeApplication() {
        webDriver.close();
    }
}