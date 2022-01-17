package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage {

    //Add page refresh kind of methods here
    protected WebDriver driver;
    protected WebDriverWait waitShort;
    protected WebDriverWait waitLong;

    public BasePage(WebDriver driver){
        this.driver = driver;
        waitLong = new WebDriverWait(driver,Duration.ofSeconds(20));
        waitShort = new WebDriverWait(driver,Duration.ofSeconds(5));

    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
//        System.out.println("OVERLAY SIZE: " + overlays.size());
        if(overlays.size() > 0){
            waitLong.until(
                ExpectedConditions.invisibilityOfAllElements(overlays));
//            System.out.println("OVERLAYS ARE INVISIBLE");
        }else{
//            System.out.println("OVERLAYS NOT FOUND");
        }
    }
}
