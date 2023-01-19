package com.test.scenarios;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class O12_TakeMultipleScreenshot {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() throws IOException {
        webDriver.get("https://www.ebay.com/");
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCase01() throws IOException {
        WebElement element = webDriver.findElement(By.xpath("//*[@class='gh-tb ui-autocomplete-input']"));
        screenCapture();
        element.sendKeys("Laptop");
        element.sendKeys(Keys.ENTER);
        screenCapture();
    }

    public void screenCapture() throws IOException {
        File source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,
                new File("C:\\Users\\Navis\\OneDrive\\Desktop\\TakeScreenshot\\Screenshot_" + (int) System.currentTimeMillis() + ".png"));
    }
}
