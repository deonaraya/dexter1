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
public class CartSummaryPage extends BasePage<CartSummaryPage> {
    public CartSummaryPage(WebDriver driver) {
        super(driver);
        instantiatePage(this);
        waitForElement(getPageLoadCondition());
    }

    @FindBy(id = "cart_summary")
    private WebElement cartSummary ;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
    private WebElement checkoutStep2 ;

    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(cartSummary);
    }

    @Override
    protected void instantiatePage(CartSummaryPage page) {
        PageFactory.initElements(driver,page);
    }

    public AuthenticationPage goToAuthenticate(){
        checkoutStep2.click();
        return new AuthenticationPage(driver);
    }


}
