package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;


public class CheckoutPage extends BasePage {

    private final By firstName = By.cssSelector("#billing_first_name");
    private final By lastName = By.cssSelector("#billing_last_name");
    private final By address1 = By.cssSelector("#billing_address_1");
    private final By city = By.cssSelector("#billing_city");
    private final By postalCode = By.cssSelector("#billing_postcode");
    private final By email = By.cssSelector("#billing_email");
    private final By placeOrder = By.cssSelector("#place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By clickHereTologinLink = By.cssSelector(".showlogin");
    private final By userNameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By countryDropdown = By.cssSelector("#billing_country");
    private final By stateDropdown = By.cssSelector("#billing_state");
    private final By directTransferRadioBtn = By.id("payment_method_bacs");
    private final By alternateCountryDropDown = By.id("select2-billing_country-container");
    private final By alternateStateDropDown = By.id("select2-billing_state-container");
    private final By productName = By.cssSelector("td[class='product-name']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage load(){
        load("/checkout/");
        return this;
    }

    public CheckoutPage enterFirstName(String fName){
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        e.clear();
        e.sendKeys(fName);
        return this;
    }

    public CheckoutPage enterLastName(String lName){
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        e.clear();
        e.sendKeys(lName);
        return this;
    }

    public CheckoutPage selectCountry(String countryName){
//        Select select = new Select(driver.findElement(countryDropdown));
//        select.selectByVisibleText(countryName);
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(alternateCountryDropDown)).click();
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+ countryName +"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }

    public CheckoutPage enterAddress1(String add1){
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(address1));
        e.clear();
        driver.findElement(address1).sendKeys(add1);
        return this;
    }

    public CheckoutPage enterCity(String cityName){
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(city));
        e.clear();
        e.sendKeys(cityName);
        return this;
    }

    public CheckoutPage selectState(String stateName){
//        Select select = new Select(driver.findElement(stateDropdown));
//        select.selectByVisibleText(stateName);
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(alternateStateDropDown)).click();
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+ stateName +"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }

    public CheckoutPage enterPostalCode(long pCode){
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(postalCode));
        e.clear();
        e.sendKeys(String.valueOf(pCode));
        return this;
    }

    public CheckoutPage enterEmail(String emailNo){
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(email));
        e.clear();
        e.sendKeys(emailNo);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        enterFirstName(billingAddress.getFirstName())
            .enterLastName(billingAddress.getLastName())
            .selectCountry(billingAddress.getCountry())
            .enterAddress1(billingAddress.getAddressLineOne())
            .enterCity(billingAddress.getCity())
            .selectState(billingAddress.getState())
            .enterPostalCode(billingAddress.getPostalCode())
            .enterEmail(billingAddress.getEmail());
        return this;
    }

    public CheckoutPage placeOrder() {
        waitForOverlaysToDisappear(overlay);
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(placeOrder));
        e.click();
        return this;
    }

    public String getNotice() {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(successNotice));
        return e.getText();
    }

    public CheckoutPage clickHereToLoginLink() {
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(clickHereTologinLink));
        e.click();
        return this;
    }

    public CheckoutPage enterUserName(String name) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(userNameFld));
        e.sendKeys(name);
        return this;
    }

    public CheckoutPage enterPassword(String pass) {
        WebElement e = waitLong.until(ExpectedConditions.visibilityOfElementLocated(passwordFld));
        e.sendKeys(pass);
        return this;
    }

    public CheckoutPage clickLogin(){
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(loginBtn));
        e.click();
        return this;
    }

    public CheckoutPage login(User user) {
        return enterUserName(user.getUsername())
            .enterPassword(user.getPassword())
            .clickLogin();
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(directTransferRadioBtn));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }

    public String getProductName(){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }
}
