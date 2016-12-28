package com.practice.automation;

import com.practice.automation.common.CommonHelper;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by chandrad on 12/24/16.
 */
public class BaseTest {

 // protected WebDriver driver ;
    public RemoteWebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = new FirefoxDriver();
//          driver = new ChromeDriver();

   //     Selenium Grid Settings
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

    @AfterTest
    public void teardown(){
        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}
