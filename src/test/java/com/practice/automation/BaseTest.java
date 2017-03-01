package com.practice.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chandrad on 12/24/16.
 */
public class BaseTest {

   public WebDriver driver ;


  //  public RemoteWebDriver driver;
   @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws MalformedURLException {

        if(browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
         else  if(browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("grid"))
        {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }
        else {
            throw new IllegalArgumentException("Invalid browser value!!");
        }

//        try {
//            driver.get(CommonHelper.getPropData("url"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        driver .get("http://automationpractice.com/index.php");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int Width = (int) toolkit.getScreenSize().getWidth();
        int Height = (int) toolkit.getScreenSize().getHeight();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(Width, Height));
    }

    @AfterClass
    public void teardown(){
        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}
