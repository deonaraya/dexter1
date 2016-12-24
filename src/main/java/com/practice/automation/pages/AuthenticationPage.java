package com.practice.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by chandrad on 12/24/16.
 */
public class AuthenticationPage extends BasePage<AuthenticationPage> {


    public AuthenticationPage(WebDriver driver) {
        super(driver);
        instantiatePage(this);
        waitForElement(getPageLoadCondition());
    }

    @FindBy(xpath = "//h3[text()='Already registered?']")
    private WebElement signInHeader ;


    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(signInHeader);
    }

    @Override
    protected void instantiatePage(AuthenticationPage page) {
        PageFactory.initElements(driver,page);
    }




}
