package cdpCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import java.util.Optional;

public class NetworkSpeed {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));

        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });

        long startTime = System.currentTimeMillis();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        WebElement button_library = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button_library.click();

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        driver.quit();

    }
}
