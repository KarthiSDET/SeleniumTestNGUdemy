
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import java.util.Optional;

class SetNetwork {

    public static void main(String[] args){
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
            false,
            20,
            20,
            50,
            Optional.of(ConnectionType.WIFI)
        ));
        driver.get("https://www.google.com");
    }
}