package com.test.scenarios;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class O11_TakeScreenshotUsingSelenium {

    private WebDriver webDriver;

    private int increment;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCase01() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@name='username']")))
                .sendKeys("Admin");

        webDriver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
    }

    @Test
    public void testCase02() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@name='username']")))
                .sendKeys("Admin");

        webDriver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
    }

    @AfterMethod
    public void takeScreenshot() throws IOException {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) webDriver);
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        increment++;
        FileUtils.copyFile(source,
                new File("C:\\Users\\Navis\\OneDrive\\Desktop\\TakeScreenshot\\Screenshot_" + increment + ".png"));
    }

    @AfterClass
    public void closeApp() {
        webDriver.quit();
    }
}
