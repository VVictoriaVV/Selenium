package com.rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Handles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.rahulshettyacademy.com/loginpagePractise/"); //https://rahulshettyacademy.com/documents-request
        WebElement accessToInterviewButton = driver.findElement(By.xpath("//a[@class='blinkingText']"));
        accessToInterviewButton.click();

        Set<String> windows = driver.getWindowHandles();//[parent,child]
        Iterator<String> iterator = windows.iterator();
        String loginPage = iterator.next();
        String documetPage = iterator.next();
        driver.switchTo().window(documetPage);


        WebElement infoEmail = driver.findElement(By.xpath("//p[@class='im-para red']"));
        System.out.println(infoEmail.getText());  // Please email us at mentor@rahulshettyacademy.com with below template to receive response
        String email = infoEmail.getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(loginPage);


        WebElement usernameField= driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys(email);

        driver.quit();

    }


}

