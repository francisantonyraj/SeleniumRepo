package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class O6_HandlingDropdownList {
    private WebDriver webDriver;
    private WebElement webElement;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://trytestingthis.netlify.app/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testCase01() throws InterruptedException {
        webElement = webDriver.findElement(By.xpath("//select[@id='option']"));
        Select select = new Select(webElement);
        List<WebElement> list = select.getOptions();
        System.out.println(list.size());
        int i = 0;
        String[] options = {"Option", "Option 1", "Option 2", "Option 3"};
        for (WebElement e : list) {
            Assert.assertEquals(options[i], e.getText());
            i++;
        }

        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByValue("option 3");
        Thread.sleep(3000);
        select.selectByVisibleText("Option 2");
    }
}
