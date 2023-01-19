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
import java.util.Iterator;
import java.util.Set;

public class O14_HandlingMultipleWindows {

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
        String parentPage = webDriver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Remote']"))).click();

        Set<String> set = webDriver.getWindowHandles();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String childPage = iterator.next();
            if (!parentPage.equals(childPage)) {
                webDriver.switchTo().window(childPage);
                String searchText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='remote']"))).getAttribute("title");
                Assert.assertEquals("remote", searchText);
                webDriver.close();
            }
        }
        webDriver.switchTo().window(parentPage);
        webDriver.close();
    }
}
