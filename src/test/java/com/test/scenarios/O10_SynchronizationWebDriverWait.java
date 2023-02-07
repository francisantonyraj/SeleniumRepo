package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class O10_SynchronizationWebDriverWait {

    private WebDriver webDriver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        webDriver = new ChromeDriver();

    }

    @BeforeMethod
    public void launch() {
        webDriver.get("https://www.ebay.com/");
        webDriver.manage().window().maximize();
    }

    @Ignore
    @Test
    public void testCase01() {
        long start = System.currentTimeMillis();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//div[@class='hl-cta__default hl-cta__default-js hl-loyalty__call-to-action']")).click();
        long end = System.currentTimeMillis();

        System.out.println("Time taken to execute the step :" + (end - start));

    }

    @Ignore
    @Test
    public void testCase02() {
        long start = System.currentTimeMillis();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hl-cta__default hl-cta__default-js hl-loyalty__call-to-action']")));
        long end = System.currentTimeMillis();

        System.out.println("Time taken to execute the step :" + (end - start));
    }

//    @Ignore
    @Test
    public void testCase03() {
        long start = System.currentTimeMillis();
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(6)) //maximum
                .pollingEvery(Duration.ofSeconds(2)) //frequency
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hl-cta__default hl-cta__default-js hl-loyalty__call-to-action']")));
        long end = System.currentTimeMillis();

        System.out.println("Time taken to execute the step :" + (end - start));
    }
}
