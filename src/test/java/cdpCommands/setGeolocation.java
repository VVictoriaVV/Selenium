package cdpCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class setGeolocation {
    public static void main(String[] args) {


        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude", 40);
        coordinates.put("longitude", 3);
        coordinates.put("accuracy", 1);


        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
     //   driver.get("https://earth.google.com/");
        driver.get("https://google.com/");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();

        driver.findElement(By.xpath("//h1[@class=' default-ltr-cache-h4k5sx-StyledContainer euy28770']")).getText();


    }
}
