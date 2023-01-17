package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class O8_DragAndDropSelenium {

    private WebDriver webDriver;
    private WebElement webElement;
    private WebElement source;
    private WebElement target;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://jqueryui.com/droppable/");
        webDriver.manage().window().maximize();
        webElement = webDriver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        webDriver.switchTo().frame(webElement);
//        webDriver.switchTo().frame(0);
    }

    @Test
    public void testCase01() throws InterruptedException {
        Thread.sleep(3000);
        source = webDriver.findElement(By.id("draggable"));
        target = webDriver.findElement(By.id("droppable"));
        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(source, target).perform();
        String value = webDriver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Thread.sleep(3000);
        Assert.assertEquals("Dropped!", value);
    }
}
