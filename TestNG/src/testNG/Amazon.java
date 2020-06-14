package testNG;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Amazon {
  public static WebElement email;
  
  public static WebElement pass;
  
  public static WebElement loginbutton;
  
  WebDriver driver;
  
  public void Primelogin() throws InterruptedException, IOException {
    System.setProperty("webdriver.chrome.driver", "D:\\software\\Study@@\\jar files\\chromedriver_win32\\chromedriver.exe");
    this.driver = (WebDriver)new ChromeDriver();
    this.driver.get("https://www.facebook.com/");
    PageFactory.initElements(this.driver, Amazon.class);
    email.sendKeys(new CharSequence[] { "sathesspartans001@gamil.com" });
    Thread.sleep(5000L);
    pass.sendKeys(new CharSequence[] { "Worldend" });
    loginbutton.click();
    String fbloginpage = this.driver.getTitle();
    System.out.println(fbloginpage);
    if (fbloginpage.equalsIgnoreCase("FaceBook")) {
      TakesScreenshot shots = (TakesScreenshot)this.driver;
      File sourcefile = (File)shots.getScreenshotAs(OutputType.FILE);
      File des = new File("D:\\googlescreenshot3.pnp");
      FileHandler.copy(sourcefile, des);
    } else {
      System.out.println("testfail");
    } 
  }
}
