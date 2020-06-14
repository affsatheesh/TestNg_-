package testNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Extends_Reports {
  WebDriver driver;
  
  ExtentReports extentreport;
  
  ExtentHtmlReporter htmlreport;
  
  ExtentTest testcase;
  
  @Test
  public void openGoogle() {
    this.testcase = this.extentreport.createTest("verify google");
    this.testcase.log(Status.INFO, "navigating to google");
    this.driver.get("https://www.google.com/");
    String title = this.driver.getTitle();
    System.out.println(title);
    if (title.equals("Google")) {
      System.out.println("the test case is passed");
    } else {
      System.out.println("the test case is failed");
    } 
  }
  
  @Test
  public void openCleartrip() {
    this.testcase = this.extentreport.createTest("verify cleartrip");
    this.testcase.log(Status.INFO, "openCleartrip");
    this.driver.get("https://www.cleartrip.com/");
    String title = this.driver.getTitle();
    System.out.println(title);
    if (title.equalsIgnoreCase("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.")) {
      this.testcase.log(Status.PASS, "cleartrip test case is passed");
    } else {
      this.testcase.log(Status.FAIL, "cleartrip testcase is failed");
    } 
  }
  
  @BeforeTest
  public void LanuchBrowser() {
    this.extentreport = new ExtentReports();
    this.htmlreport = new ExtentHtmlReporter("Extentsreport.html");
    this.extentreport.attachReporter(new ExtentReporter[] { (ExtentReporter)this.htmlreport });
    System.setProperty("webdriver.chrome.driver", "D:\\software\\Study@@\\jar files\\chromedriver_win32\\chromedriver.exe");
    this.driver = (WebDriver)new ChromeDriver();
  }
  
  @AfterTest
  public void CloseBrowser() {
    this.driver.quit();
    this.extentreport.flush();
  }
}
