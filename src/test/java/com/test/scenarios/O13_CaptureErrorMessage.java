package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class O13_CaptureErrorMessage {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() {
        webDriver.get("https://www.naukri.com/");
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCase01() {
        webDriver.findElement(By.xpath("//a[@title='Jobseeker Login']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")))
                .sendKeys("abc");
        webDriver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("abc");

        webDriver.findElement(By.xpath("//button[text()='Login']")).click();

        String errMsg = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[@class='server-err']")))
                .getText();
        Assert.assertEquals(errMsg, "Invalid details. Please check the Email ID - Password combination.");
    }
}
