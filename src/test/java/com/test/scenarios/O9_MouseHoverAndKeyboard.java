package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class O9_MouseHoverAndKeyboard {

    private WebDriver webDriver;

    private WebElement webElement;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
    }

//    @BeforeMethod
//    public void launch() {
//        webDriver.get("https://www.ebay.com/");
//        webDriver.manage().window().maximize();
//    }

    @Ignore
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

    //By using the sendKeys
    @Ignore
    @Test
    public void testCase02() {
        webDriver.get("https://demoqa.com/text-box");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("userName")).sendKeys("Ram");
        webDriver.findElement(By.id("userEmail")).sendKeys("ram@gmail.com");
        webElement = webDriver.findElement(By.id("currentAddress"));
        webElement.sendKeys("17, BH Colony, St.Luise Road,Bangalore");
        webElement.sendKeys(Keys.CONTROL);
        webElement.sendKeys("A");
        webElement.sendKeys(Keys.CONTROL);
        webElement.sendKeys("C");
        webElement.sendKeys(Keys.TAB);
        webElement = webDriver.findElement(By.id("permanentAddress"));
        webElement.sendKeys(Keys.CONTROL);
        webElement.sendKeys("V");
    }

    //By using Actions class
//    @Ignore
    @Test
    public void testCase03() {
        webDriver.get("https://demoqa.com/text-box");
        webDriver.manage().window().maximize();
        Actions actions = new Actions(webDriver);
        webDriver.findElement(By.id("userName")).sendKeys("Ram");
        webDriver.findElement(By.id("userEmail")).sendKeys("ram@gmail.com");
        webElement = webDriver.findElement(By.id("currentAddress"));
        webElement.sendKeys("17, BH Colony, St.Luise Road,Bangalore");

        //select current address using ctl+A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        //select current address using ctl+c
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        
        //move to the permanent address field
        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        //paste the current address to the permanent address
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
    }
}