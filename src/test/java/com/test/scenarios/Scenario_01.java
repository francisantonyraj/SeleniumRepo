package com.test.scenarios;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.model.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Scenario_01 {
    private static WebDriver webDriver;
    private LoginPage loginPage = new LoginPage();
    private TakesScreenshot screenshot;
    private File sourceFile;
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private static int increment = 0;

    @BeforeClass
    public void setup() {
        extentReports = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\STMExtentReport.html", true);
        extentReports
                .addSystemInfo("Host Name", "Software Testing")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Francis");
        extentReports.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void launch() throws InterruptedException {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }

    @Test
    public void testCase01() {
        loginPage.setPageHeader(findElement(webDriver, "//*[text()='Login']").isDisplayed());
        loginPage.setPasswordLabel(findElement(webDriver, "//*[text()='Username']").isDisplayed());
        loginPage.setUsernameLabel(findElement(webDriver, "//*[text()='Password']").isDisplayed());

        Assert.assertEquals(true, loginPage.isPageHeader());
        Assert.assertEquals(true, loginPage.isUsernameLabel());
        Assert.assertEquals(true, loginPage.isPasswordLabel());
    }

    @Ignore
    @Test()
    public void testCase02() {
        findElement(webDriver, "//input[@placeholder='Username']").sendKeys("Admin");
        findElement(webDriver, "//input[@placeholder='Password']").sendKeys("admin123");
        findElement(webDriver, "//button").click();
    }

    @Ignore
    @Test
    public void testCase03() {
        loginPage.setTitle(findElement(webDriver, "//p[text()='Paul Collings']").getText());
        Assert.assertEquals("Paul Colling", loginPage.getTitle());
    }

    @AfterMethod()
    public void screenshot(ITestResult result) throws IOException {
        //when there is failure
        if (ITestResult.FAILURE == result.getStatus()) {
            extentTest.log(LogStatus.FAIL, "Test Case Failed "+result.getName());
            extentTest.log(LogStatus.FAIL, "Test Case Failed "+result.getThrowable());

            String screenShotPath = Scenario_01.getScreenshot(webDriver, result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenShotPath));
//            screenshot = ((TakesScreenshot) webDriver);
//            sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(sourceFile, new File("C:\\Users\\Navis\\Desktop\\TakeScreenshot\\Screenshot" + ++increment + ".png"));
        }
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/FailedTestScreenshots/" + screenshotName + dataName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
    @AfterClass
    public void close() {
        webDriver.quit();
    }

    public WebElement findElement(WebDriver webDriver, String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }
}
