package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class O7_HandlingFileUploadAutoIT {
    private WebDriver webDriver;
    private WebElement element;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.foundit.in/seeker/registration");
        element = webDriver.findElement(By.xpath("//input[@name='file']"));
    }

    @Test
    public void testCase01() {
        element.sendKeys("C:\\Users\\Navis\\Downloads\\St.MarysGlobalEnterprices.pdf");
    }

    @Test
    public void testCase02() {

    }
}
