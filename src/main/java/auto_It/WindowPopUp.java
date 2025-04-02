package auto_It;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  driver.get("https://the-internet.herokuapp.com/"); original site with popup(login password)


        driver.get("http://admin:admin@the-internet.herokuapp.com/");// admin:admin - login and password
        driver.findElement(By.linkText("Basic Auth")).click();




    }
}
