package cdpCommands;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;

import java.util.Optional;

public class NetworkingBlockRequest {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();


        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.linkText("Browse Products")).click();
        //  WebElement button_library = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement addToCart = driver.findElement(By.xpath("//button[@class='add-to-cart btn btn-default']"));
        addToCart.click();
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
