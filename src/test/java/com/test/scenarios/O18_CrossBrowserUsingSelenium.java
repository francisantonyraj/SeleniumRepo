package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class O18_CrossBrowserUsingSelenium {

    private WebDriver webDriver;
    private ChromeOptions chromeOptions;

    @BeforeClass
    public void setUp() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
    }

    @Test(dataProvider = "dataProvider")
    public void setUp(String tagName1, String tagName2) {

        if (!tagName1.equals(null)) {
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.get("https://leafground.com/");
            webDriver.manage().window().maximize();
            //checking the count of the link
            List<WebElement> list = webDriver.findElements(By.tagName(tagName1));
            int linkCount = list.size();
            Assert.assertEquals(linkCount, 109);
        }
        if (!tagName2.equals(null)) {
            webDriver = new EdgeDriver();
            webDriver.get("https://leafground.com/");
            webDriver.manage().window().maximize();
            List<WebElement> list = webDriver.findElements(By.tagName(tagName2));
            int linkCount = list.size();
            Assert.assertEquals(linkCount, 109);
        }
    }

    @DataProvider(name = "dataProvider")
    public Object[][] execute() {
        return new Object[][]{{"a", "a"}};
    }


    @AfterMethod
    public void closeApp() {
        webDriver.quit();
    }
}