package testNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Extant_Report {
  WebDriver driver;
  
  ExtentReports extentreport;
  
  ExtentHtmlReporter htmlreporter;
  
  ExtentTest testcase;
  
  @Test
  public void opengoogle() throws IOException {
    ExtentTest testcase = this.extentreport.createTest("google_open");
    this.driver.get("https://www.google.com/");
    String title = this.driver.getTitle();
    if (title.equalsIgnoreCase("cleartrip")) {
      testcase.log(Status.PASS, "its wonderfull");
    } else {
      testcase.log(Status.FAIL, "the testcase is failed");
      TakesScreenshot screenshot = (TakesScreenshot)this.driver;
      File src = (File)screenshot.getScreenshotAs(OutputType.FILE);
      File des = new File("googletestcase3.png");
      FileHandler.copy(src, des);
      testcase.addScreenCaptureFromPath("googletestcase3.png", "google spelling mistakes");
    } 
  }
  
  @BeforeSuite
  public void LanuchBrower() {
    this.extentreport = new ExtentReports();
    this.htmlreporter = new ExtentHtmlReporter("firstReport1.html");
    this.extentreport.attachReporter(new ExtentReporter[] { (ExtentReporter)this.htmlreporter });
    System.setProperty("webdriver.chrome.driver", "D:\\software\\Study@@\\jar files\\chromedriver_win32\\chromedriver.exe");
    this.driver = (WebDriver)new ChromeDriver();
  }
  
  @AfterSuite
  public void CloseBrowser() {
    this.driver.quit();
    this.extentreport.flush();
  }
}
