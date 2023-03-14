package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class O17_WebTable {

    private WebDriver webDriver;
    private String[] headerName = {"Name", "Country", "Representative", "Join Date", "Status", "Activity"}; //Expected value

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
    }

    @BeforeMethod
    public void launch() throws InterruptedException {
        webDriver.get("https://leafground.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//i[@class='pi pi-table layout-menuitem-icon']")).click();
        webDriver.findElement(By.xpath("//i[@class='pi pi-fw pi-table layout-menuitem-icon']")).click();
    }

    @Test
    public void testcase01() {
        List<WebElement> listTableColumn = webDriver
                .findElements(By.xpath("//div[@class='ui-datatable-scrollable-header-box']//table[@role='grid']/thead/tr/th"));

        Iterator<String> iterator = Arrays.stream(headerName).iterator();
        for (WebElement webElement : listTableColumn) { //foreach loop
            String actualValue = webElement.getText();
            String expectedValue = iterator.next();
            Assert.assertEquals(actualValue, expectedValue);
        }
    }


    @AfterMethod
    public void close() {
        webDriver.close();
    }
}