package cdpCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class CdpCommandsTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        DevTools devtools = driver.getDevTools();
        devtools.createSession();


        Map deviceMetrics = new HashMap();
        deviceMetrics.put("width", 600);
        deviceMetrics.put("height", 1000);
        deviceMetrics.put("deviceScaleFactor", 55);
        deviceMetrics.put("mobile", true);


        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");


        WebElement burger_menu = driver.findElement(By.xpath("//button[@class='navbar-toggler']"));
        burger_menu.click();
        Thread.sleep(2000);

        WebElement button_library = driver.findElement(By.linkText("Library"));
        button_library.click();
    }
}
