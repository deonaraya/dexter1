package com.practice.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.awt.*;

/**
 * Created by chandrad on 12/24/16.
 */
public class BaseTest {

    protected WebDriver driver ;

    @BeforeClass
    public void setUp(){
       // driver = new FirefoxDriver();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("test-type");
//        driver = new ChromeDriver(options);

        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int Width = (int) toolkit.getScreenSize().getWidth();
        int Height = (int) toolkit.getScreenSize().getHeight();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(Width, Height));
    }
}
