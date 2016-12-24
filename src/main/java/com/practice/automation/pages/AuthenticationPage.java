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

    @FindBy(id = "email_create")
    private WebElement createEmailTextField ;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccount ;

    @FindBy(id = "email")
    private WebElement emailTextField ;

    @FindBy(id = "passwd")
    private WebElement passwordTextField ;

    @FindBy(id = "SubmitLogin")
    private WebElement login ;


    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(signInHeader);
    }

    @Override
    protected void instantiatePage(AuthenticationPage page) {
        PageFactory.initElements(driver,page);
    }


    public BillingAddressPage signIn(String email, String password){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        login.click();
        return new BillingAddressPage(driver);
    }

    public SignUpPage signUp(String createEmail){
        createEmailTextField.sendKeys(createEmail);
        createAccount.click();
        return new SignUpPage(driver);
    }



}
