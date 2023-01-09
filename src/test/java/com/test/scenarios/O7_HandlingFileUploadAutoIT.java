package com.test.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class O7_HandlingFileUploadAutoIT {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.foundit.in/seeker/registration");
    }

    @Test
    public void testCase02() throws IOException, InterruptedException {
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//span[@class='browse-text']")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Navis\\OneDrive\\Desktop\\Sample\\FileUpload.exe");
    }
}
