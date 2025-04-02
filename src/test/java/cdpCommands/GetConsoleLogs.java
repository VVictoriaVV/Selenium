package cdpCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class GetConsoleLogs {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();

        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();

        WebElement addToCart = driver.findElement(By.xpath("//button[@class='add-to-cart btn btn-default']"));
        addToCart.click();
        driver.findElement(By.linkText("Cart")).click();

        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("2");

        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);//get LogEntires object
        List<LogEntry> logs = entry.getAll(); //return all logs

        for(LogEntry e : logs){   //iterating through list and printing each log message
            System.out.println(e.getMessage());
        }


    }
}
