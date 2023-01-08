package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class O5_HandlingAutoSuggestion {

    private WebDriver webDriver;
    private WebElement webElement;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();
        webElement = webDriver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
    }

    @Test
    public void testCase01() {
        webElement.sendKeys("Shoes");
        webElement.sendKeys(Keys.ARROW_DOWN);
        webElement.sendKeys(Keys.ENTER);
    }
}
