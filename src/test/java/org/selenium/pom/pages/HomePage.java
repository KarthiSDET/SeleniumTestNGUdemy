package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        waitLong.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;
    }

    public StorePage navigateToStoreUsingMenu() {
        WebElement e = waitLong.until(ExpectedConditions.elementToBeClickable(storeMenuLink));
        e.click();
        return new StorePage(driver);
    }
}
