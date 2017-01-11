package com.practice.automation;

import com.practice.automation.common.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by chandrad on 12/24/16.
 */
public class BaseTest {

    protected WebDriver driver ;
  //  public RemoteWebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws MalformedURLException {

        if(browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
         else  if(browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else {
            throw new IllegalArgumentException("Invalid browser value!!");
        }


//        Grid Settings
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);


        try {
            driver.get(CommonHelper.getPropData("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
