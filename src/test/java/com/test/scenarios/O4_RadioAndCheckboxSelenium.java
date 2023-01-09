package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class O4_RadioAndCheckboxSelenium {

    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @BeforeMethod
    public void launch() throws InterruptedException {
        webDriver.manage().window().maximize();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        webDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        webDriver.findElement(By.xpath("//button[text()=' Login ']")).click();
    }

    @Test
    public void testCase01() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//*[text()='Male']")).click();
        webDriver.findElement(By.xpath("//*[text()='Yes']")).click();
    }

    @AfterClass
    public void closeApplication() {
        webDriver.close();
    }
}
