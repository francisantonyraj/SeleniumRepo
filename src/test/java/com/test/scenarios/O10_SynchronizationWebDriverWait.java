package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void testCase01() {
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//div[@class='hl-cta__default hl-cta__default-js hl-loyalty__call-to-action']")).click();
    }

    @Test
    public void testCase02() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hl-cta__default hl-cta__default-js hl-loyalty__call-to-action']")));
    }

    @Test
    public void testCase03() {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(6)) //maximum
                .pollingEvery(Duration.ofSeconds(2)) //frequency
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hl-cta__default hl-cta__default-js hl-loyalty__call-to-action']")));
    }
}
