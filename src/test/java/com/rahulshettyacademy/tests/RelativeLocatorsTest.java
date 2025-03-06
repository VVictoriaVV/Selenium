package com.rahulshettyacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsTest {
    @Test
    public void loginTest() {

       // ChromeOptions options = new ChromeOptions();// headless
      //  options.addArguments("headless");


        WebDriver driver = new ChromeDriver();//options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.click();
        name.sendKeys("Rustam");


        // WebElement nameTag= driver.findElement(RelativeLocator.with(By.tagName("label")).above(name));
        WebElement nameTag = driver.findElement(with(By.tagName("label")).above(name));
        System.out.println(nameTag.getText());

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
        checkbox.click();
        WebElement icecream = driver.findElement(with(By.xpath("//label[text()='Check me out if you Love IceCreams!']")).toRightOf(checkbox));
        System.out.println(icecream.getText());



        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@class='form-control']"));
        WebElement submit = driver.findElement(with(By.tagName("input")).below(dateOfBirth));
        submit.click();
    }
}