package com.markeplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "fieldEmail")
    WebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='enter your passsword']")
    WebElement fieldPassword;

    @FindBy(id = "buttonLogin")
    WebElement buttonLogin;


    public void Login(String email, String password) {

        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(password);
        buttonLogin.click();
    }

    public void goTo() {

        driver.get("https://rahulshettyacademy.com/client");
    }

//    public WebElement getProductList() {
//        List<WebElement> boxOfThing = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
//        WebElement product = boxOfThing.stream().filter(s ->
//                s.findElement(By.xpath("//h5/b[text()='ADIDAS ORIGINAL']")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//        return product;
//    }
//    public void submit(){
//        WebElement addToCart = driver.findElement(By.xpath("//div[@class='card-body']/button[@class='btn w-10 rounded']"));
//        System.out.println(addToCart);
//       addToCart.click();
//    }
}
