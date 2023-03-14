package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class O20_Test1 {
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
        webDriver.get("https://leafground.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//i[@class='pi pi-table layout-menuitem-icon']")).click();
        webDriver.findElement(By.xpath("//i[@class='pi pi-fw pi-table layout-menuitem-icon']")).click();
    }

    @Test
    public void testCase01() {
        WebElement element = webDriver
                .findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table[1]/tbody/tr[1]/td[1]"));
        String value = element.getText();
        System.out.println(value);
    }
}
