package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class O9_MouseHoverAndKeyboard {

    private WebDriver webDriver;

    private WebElement webElement;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() {
        webDriver.get("https://www.ebay.com/");
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCase01() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        webElement = webDriver.findElement(By.xpath("//div[@class='hl-cat-nav']//li[@class='hl-cat-nav__js-tab']//*[text()='Electronics']"));
        actions.moveToElement(webElement).perform();
        Thread.sleep(5000);
        webElement = webDriver.findElement(By.xpath("//*[text()='Cameras and photos']"));
        actions.moveToElement(webElement).click().build().perform();
        String pageTitle = webDriver.getTitle();
        Assert.assertEquals("Cameras & Photo for sale | eBay", pageTitle);
    }
}