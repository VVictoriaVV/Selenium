package cdpCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class MobileEmulatorTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();


        //send command to CDP methods
        devTools.send(Emulation.setDeviceMetricsOverride(600, 950, 55, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        WebElement burger_menu = driver.findElement(By.xpath("//button[@class='navbar-toggler']"));
        burger_menu.click();
         Thread.sleep(2000);

        WebElement button_library = driver.findElement(By.linkText("Library"));
        button_library.click();



    }
}
