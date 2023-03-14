package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class O16_HandlingIFrames {

    private WebDriver webDriver;

    @BeforeClass
    public void launch() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void setUp() {
        webDriver.navigate().to("https://leafground.com/");
        webDriver.manage().window().maximize();
    }

    //    @Test
    public void testCase_FrameBasedOnIndex() throws InterruptedException {
        Thread.sleep(300);
        webDriver.findElement(By.xpath("//i[@class='pi pi-globe layout-menuitem-icon']")).click();
        webDriver.findElement(By.xpath("//a/span[text()='Frame']")).click();
        webDriver.switchTo().frame(0);
        webDriver.findElement(By.xpath("//button[@id='Click']")).click();

    }

    @Test
    public void testCase_FrameBasedOnId() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//i[@class='pi pi-globe layout-menuitem-icon']")).click();
        webDriver.findElement(By.xpath("//a/span[text()='Frame']")).click();
        WebElement element = webDriver.findElement(By.xpath("//iframe[@id='frame2']"));
        webDriver.switchTo().frame(element);
        webDriver.switchTo().parentFrame();

        webDriver.findElement(By.xpath("//button[@id='Click']")).click();
    }

    @AfterMethod
    public void closeApp() {
        webDriver.quit();
    }
}
