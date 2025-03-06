package com.rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/");
       // driver.get("https://www.amazon.com/");
        //  a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();


        //Actions - is a Class in Java
        Actions a= new Actions(driver);



        WebElement searchField= driver.findElement(By.xpath("//input[@placeholder='Search Costco']"));
       a.moveToElement(searchField).click().keyDown(Keys.SHIFT).sendKeys("beef").doubleClick().build().perform();

        WebElement serviceMove=driver.findElement(By.xpath("//a[@aria-label='Services']"));
        a.moveToElement(serviceMove).contextClick().build().perform();















    }
}
