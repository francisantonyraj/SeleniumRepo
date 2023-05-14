package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class O19_Test2 {


    private WebDriver webDriver;
    private ChromeOptions chromeOptions;

    private List<WebElement> elementList;

    private String[] headerName = {"Product", "Price", "Availability"};

    @BeforeClass
    public void setUp() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get("https://francisantonyraj.github.io/");
    }

    @Test
    public void testcase01() {
        webDriver.findElement(By.xpath("//*[@class='webtable']")).click();
        webDriver.switchTo().frame("frame");
        elementList = webDriver.findElements(By.xpath("//table[@name='webtable']/thead/tr/th"));
        int columns = elementList.size();
        Assert.assertEquals(columns, 3);
        int i = 0;
        for (WebElement element : elementList) {
            Assert.assertEquals(element.getText(), headerName[i++]);
        }
        elementList = webDriver.findElements(By.xpath("//table[@name='webtable']/tbody/tr"));
        int rows = elementList.size();
        Assert.assertEquals(rows, 3);
    }

    @Test(dataProvider = "dataContainer")
    public void testcase02(int row, String expectedProduct, String expectedPrice, String expectedAvailability) {
        List<WebElement> descElements = webDriver.findElements(By.xpath("//table[@name='webtable']/tbody/tr[" + row + "]/td"));
        Iterator<WebElement> iterator = descElements.iterator();
        Assert.assertEquals(expectedProduct, iterator.next().getText());
        Assert.assertEquals(expectedPrice, iterator.next().getText());
        Assert.assertEquals(expectedAvailability, iterator.next().getText());
    }

    @DataProvider(name = "dataContainer")
    public Object[][] webTable() {
        return new Object[][]{
                {1, "Laptop", "$999.99", "In Stock"},
                {2, "Smartphone", "$99.99", "Out Of Stock"},
                {3, "Tablet", "$349.99", "In Stock"}};
    }
}
