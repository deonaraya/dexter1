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
public class PaymentPage extends BasePage<PaymentPage> {
    public PaymentPage(WebDriver driver) {
        super(driver);
        instantiatePage(this);
        waitForElement(getPageLoadCondition());
    }

    @FindBy(className = "paiement_block")
    private WebElement paymentSection ;

    @FindBy(className = "bankwire")
    private WebElement payByWire ;

    @FindBy(className = "cheque")
    private WebElement payByCheck ;

    @FindBy(xpath = "//span[text()='I confirm my order']//parent::button")
    private WebElement confirmOrder ;


    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(paymentSection);
    }
    @Override
    protected void instantiatePage(PaymentPage page) {
        PageFactory.initElements(driver,page);
    }

    public PaymentPage selectPaymentMode(String paymentMethod){
        if (paymentMethod == "payByWire")
            payByWire.click();
        else if(paymentMethod == "payByCheck")
            payByCheck.click();
        return new PaymentPage(driver);
    }

    public OrderConfirmationPage confrimOrder(){
        confirmOrder.click();
        return new OrderConfirmationPage(driver);
    }
}
