package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartBtn = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage load(){
        load("/store");
        return this;
    }

    public Boolean isLoaded(){
        return waitLong.until(ExpectedConditions.urlContains("/store"));
    }

    public Boolean isLoadedAfterSearch(){
        return waitLong.until(ExpectedConditions.urlContains("Blue&post_type=product"));
    }

    public StorePage enterTextInSearchFld(String txt) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(searchFld));
        e.sendKeys(txt);
        return this;
    }

    public StorePage clickSearchBtn(){
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(searchBtn));
        e.click();
        return this;
    }

    public String getTitle() {
       waitLong.until(
            ExpectedConditions.elementToBeClickable(title));
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public StorePage clickAddToCartBtn(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        e.click();
        return this;
    }

    public CartPage clickViewCart() {
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
        e.click();
        return new CartPage(driver);
    }
}
