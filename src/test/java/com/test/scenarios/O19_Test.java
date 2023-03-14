package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class O19_Test {

    private WebDriver webDriver;
    private ChromeOptions chromeOptions;
    private String[] headerName = {"Name", "Country", "Representative", "Join Date", "Status", "Activity"};

    @BeforeClass
    public void setUp() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://leafground.com/");
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void launch() throws InterruptedException {
        webDriver.findElement(By.xpath("//i[@class='pi pi-table layout-menuitem-icon']")).click();
        webDriver.findElement(By.xpath("//i[@class='pi pi-fw pi-table layout-menuitem-icon']")).click();
    }

    //    @Test
    public void testcase01() {
        List<WebElement> listTableColumn = webDriver
                .findElements(By.xpath("//div[@class='ui-datatable-scrollable-header-box']/following::table[1]/thead/tr/th"));
        Iterator<String> iterator = Arrays.stream(headerName).iterator();
        if (iterator.hasNext()) {
            for (WebElement webElement : listTableColumn) {
                String actual = webElement.getText();
                String expected = iterator.next();
                Assert.assertEquals(actual, expected);
            }
        }
    }

    @Test(dataProvider = "dataProvider")
    public void testcase02(int row, String[] values) {
        List<WebElement> listTableColumn = webDriver
                .findElements(By.xpath("//div[@class='ui-datatable-scrollable-header-box']/following::table[1]/thead/tr/th"));
        Iterator<String> iterator = Arrays.stream(values).iterator();
        if (iterator.hasNext()) {
            for (WebElement webElement : listTableColumn) {
                String actual = webElement.getText();
                String expected = iterator.next();
                Assert.assertEquals(actual, expected);
            }
        }
    }

    @DataProvider(name = "dataProvider")
    public Object[][] multipleData() {
        return new Object[][]{{0, "Name", "Country", "Representative", "Join Date", "Status", "Activity"},
                {1,"Julie Chavez","Australia",""}};
    }

    @AfterTest
    public void close() {
        webDriver.close();
    }
}