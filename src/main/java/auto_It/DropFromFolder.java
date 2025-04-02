package auto_It;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DropFromFolder {

    public static void main(String[] args) throws InterruptedException, IOException {


        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.adobe.com/acrobat/online/pdf-to-jpg.html");


        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//article[@class='dropZoneContent LifecycleDropZone__dropZoneContent___14tmO DropzoneContent__dropzoneCursorPointer___548sT']"));
        button.click();
        Thread.sleep(2000);

        //shift focus on window to choose file

        Runtime.getRuntime().exec("C:\\Users\\79255\\OneDrive\\Документы\\uploadFile1.exe");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='react-aria2560609049-:rh:']")));


        //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert to JPG']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Convert to JPG']")).click();
        //  driver.findElement(By.xpath("//button[@id='react-aria2560609049-:rh:']")).click();


        //   Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Download']")));

        driver.findElement(By.xpath("//button[text()='Download']")).click();

        File f = new File("C:\\Users\\79255\\Downloads\\ESOL-Programs-2024.zip");
        if (f.exists()) {
            System.out.println("File is downloaded");
        } else {
            System.out.println("File is not downloaded");
        }

        driver.quit();
    }
}