package org.selenium.pom.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.base.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class NaukriTest extends BaseTest{

    private static WebDriver driver;


    public static void clicOnCollege(){
        try{
           WebElement collegeElemntInMenu =  driver.findElement(By.xpath("//a[contains(text(),'Home')]/../..//a[contains(text(),'Colleges')]"));
           collegeElemntInMenu.click();
            System.out.println("Successfully clicked");
        }catch (Exception e){
            throw new RuntimeException("Unable to click on college Element",e);
        }
    }

    private static void navigateToPopup() {
        //        driver.switchTo().alert().dismiss();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> itr = windowHandles.iterator();
        while(itr.hasNext()){
            String childWindow = itr.next();
            driver.switchTo().window(childWindow);
            WebElement dismissBtnInCollegeAlertPopup =  driver.findElement(By.xpath("//div[@id='dismiss-button']/div"));
            dismissBtnInCollegeAlertPopup.click();
            break;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.eduvidya.com/");
        Thread.sleep(3000);
        clicOnCollege();
        navigateToPopup();

    }
}
