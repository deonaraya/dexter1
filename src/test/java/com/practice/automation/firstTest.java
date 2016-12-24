package com.practice.automation;

import com.practice.automation.pages.HomePage;
import org.testng.annotations.Test;

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

}
