package com.practice.automation;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.net.MalformedURLException;

/**
 * Created by chandrad on 12/24/16.
 */
public class BaseTest {

 // protected WebDriver driver ;
    public RemoteWebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = new FirefoxDriver();
//          driver = new ChromeDriver();

   //     Selenium Grid Settings
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);



        driver.get("http://automationpractice.com/index.php");
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
