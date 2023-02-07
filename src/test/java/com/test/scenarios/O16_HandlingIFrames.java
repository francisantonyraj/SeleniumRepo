package com.test.scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class O16_HandlingIFrames {

    private WebDriver webDriver;
    @BeforeClass
    public void launch(){
        webDriver = new ChromeDriver();
    }
}
