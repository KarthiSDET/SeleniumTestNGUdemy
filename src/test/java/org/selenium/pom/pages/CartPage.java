package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;


public class CartPage extends BasePage {

    /*private final By productName = By.cssSelector("td[class='product-name'] > a");
    private final By checkoutBtn = By.cssSelector(".checkout-button");
    private final By cartHeading = By.cssSelector(".has-text-align-center");*/

    @FindBy(css = "td[class='product-name'] > a") private WebElement productName;
    @FindBy(css = ".checkout-button") private WebElement checkoutBtn;
    @FindBy(css = ".has-text-align-center") @CacheLookup private WebElement cartHeading;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CartPage isLoaded(){
        waitLong.until(ExpectedConditions.textToBePresentInElement(cartHeading, "Cart"));
        return this;
    }

    public String getProductName() {
        return waitLong.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public CheckoutPage checkout() {
        waitLong.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        return new CheckoutPage(driver);
    }
}
