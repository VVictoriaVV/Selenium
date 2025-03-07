package com.marketplace.tests;

import com.markeplace.LandingPage;
import com.rahulshettyacademy.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AuthorisationTest extends BaseTest {
    @Test
    public void launchApplication() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));


        LandingPage lp = new LandingPage(driver);
        lp.goTo();
//       lp.Login("anshika@gmail.com", "Iamking@000");
//        lp.getProductList();
//        lp.submit();


        List<WebElement> boxOfThing = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
        WebElement product = boxOfThing.stream().filter(s ->
                s.findElement(By.xpath("//h5/b[text()='ADIDAS ORIGINAL']")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);


        System.out.println(product);

        WebElement addToCart = product.findElement(By.xpath("//div[@class='card-body']/button[@class='btn w-10 rounded']"));
        System.out.println(addToCart);
        addToCart.click();

        driver.quit();
    }
}
//
////
/////