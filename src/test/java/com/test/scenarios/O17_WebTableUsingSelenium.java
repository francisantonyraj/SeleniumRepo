package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;

public class O17_WebTableUsingSelenium {

    private WebDriver webDriver;
    private ChromeOptions chromeOptions;

    @BeforeClass
    public void setUp() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
    }

    @BeforeMethod
    public void launch() {
        webDriver.get("https://francisantonyraj.github.io");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@class='webtable']")).click();
        webDriver.switchTo().frame("frame");
    }

    @Test
    public void testcase01() {
        String[] headerNames = {"Product", "Price", "Availability"};
        List<WebElement> elementList = webDriver.findElements(By.xpath("//table/thead/tr/th"));
        int size = elementList.size();
        Assert.assertEquals(size, 3);
        for (int i = 0; i < size; i++) {
            String expectedResult = headerNames[i];
            String actualResult = elementList.get(i).getText();
            Assert.assertEquals(expectedResult, actualResult);
        }
    }

    @Test(dataProvider = "datas")
    public void testcase02(int row, String product, String price, String availability) {
        List<WebElement> list = webDriver.findElements(By.xpath("//table/tbody/tr[" + row + "]/td"));
        Iterator<WebElement> iterator = list.iterator();
        Assert.assertEquals(product, iterator.next().getText());
        Assert.assertEquals(price, iterator.next().getText());
        Assert.assertEquals(availability, iterator.next().getText());
    }

    @DataProvider(name = "datas")
    public Object[][] datas() {
        return new Object[][]{{1, "Laptop", "$999.99", "In Stock"}
                , {2, "Smartphone", "$99.99", "Out Of Stock"}
                , {3, "Tablet", "$349.99", "In Stock"}};
    }
}
