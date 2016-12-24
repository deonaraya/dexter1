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
public class OrderConfirmationPage extends  BasePage<OrderConfirmationPage> {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        instantiatePage(this);
        waitForElement(getPageLoadCondition());
    }

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement orderConfirmMessage ;

    @FindBy(xpath = "//div[@class='box order-confirmation']")
    private WebElement OrderConfrimSection ;

    @FindBy(xpath = "//p[@class='cart_navigation exclusive']/a")
    private WebElement navToOrderHistory ;

    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(orderConfirmMessage);
    }

    @Override
    protected void instantiatePage(OrderConfirmationPage page) {
        PageFactory.initElements(driver,page);
    }

    public OrderHistoryPage backToORder(){
        navToOrderHistory.click();
        return new OrderHistoryPage(driver);
    }
}
