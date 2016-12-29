package com.practice.automation;

import com.practice.automation.common.CommonHelper;
import com.practice.automation.pages.HomePage;
import org.testng.annotations.Test;

/**
 * Created by chandrad on 12/28/16.
 */
public class SignUpTest extends BaseTest  {

    @Test
    public void pTest() {

        System.out.println("Test Case One in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());

        HomePage pg = new HomePage(driver);
        pg.getProductNames().getProductPrices().addnew().goToSummary()
                .goToAuthenticate().signUp(CommonHelper.getUniqueEmail("chandra")) ;

    }
}
