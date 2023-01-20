package com.test.scenarios;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class O15_HandlingAlertMessages {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() {
        webDriver.get("https://francisantonyraj.github.io/");
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCase01() {
        webDriver.findElement(By.xpath("//button[@class='alertMessage']")).click();
        String text = webDriver.switchTo().alert().getText();
        Assert.assertEquals(text, "Hello World");
        webDriver.switchTo().alert().accept();
    }

    @Test
    public void testCase02() {
        webDriver.findElement(By.xpath("//button[@class='confirmMessage']")).click();
        webDriver.switchTo().alert().accept();
    }

    @Test
    public void testCase03() throws InterruptedException {

        webDriver.findElement(By.xpath("//button[@class='promptMessage']")).click();
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("Bangalore");
        alert.accept();
    }
}
