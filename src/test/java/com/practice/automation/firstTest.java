package com.practice.automation;

import com.practice.automation.common.ReadPropertyFile;
import com.practice.automation.pages.HomePage;
import org.testng.annotations.Test;

import java.io.InputStream;

/**
 * Created by chandrad on 12/24/16.
 */
public class firstTest extends BaseTest {

@Test
    public void test(){
    HomePage pg = new HomePage(driver);
    pg.getProductNames().getProductPrices().addnew().goToSummary()
            .goToAuthenticate().signIn("byju@mailinator.com","Cisco@1234").goToShipping().goToPayment()
            .selectPaymentMode("payByWire").confrimOrder().backToORder();

}

    @Test
    public void test2(){

        InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("config.properties");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
    }

}
