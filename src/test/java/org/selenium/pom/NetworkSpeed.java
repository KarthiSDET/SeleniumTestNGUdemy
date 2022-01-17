package org.selenium.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

public class NetworkSpeed {

    public ChromeDriver driver(){
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


    @Test
    public void highSpeed(){
        ChromeDriver driver = driver();
        long startTime = System.currentTimeMillis();
        driver.get("https://www.qed42.com");
        long endTime = System.currentTimeMillis();

        System.out.println("Slow Network: Page loaded in " + (endTime - startTime) + "milliseconds");
    }
    @Test
    public void emulateSlowNetwork() {
        ChromeDriver driver = driver();
        DevTools devTool = driver.getDevTools();
        devTool.createSession();
        devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTool.send(Network.emulateNetworkConditions(
            false,100,200000,100000,Optional.of(ConnectionType.CELLULAR3G)));

        long startTime = System.currentTimeMillis();
        driver.get("https://www.qed42.com");
        long endTime = System.currentTimeMillis();

        System.out.println("Slow Network: Page loaded in " + (endTime - startTime) + "milliseconds");
    }

    @Test
    public void accessURLNormal() {
        ChromeDriver driver = driver();
        long startTime = System.currentTimeMillis();
        driver.get("https://www.qed42.com");
        long endTime = System.currentTimeMillis();

        System.out.println("Normal Way: Page loaded in " + (endTime - startTime) + " milliseconds");
    }
}
