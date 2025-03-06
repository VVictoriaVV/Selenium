package com.rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSort2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.rahulshettyacademy.com/seleniumPractise/#/offers");


        WebElement searchField = driver.findElement(By.xpath("//input[@id='search-field']"));
        searchField.click();
        searchField.sendKeys("Rice");


        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
       List<WebElement> filtredList = veggies.stream().filter(veggetable->veggetable.getText().contains("Rice")).
                collect(Collectors.toList());
       //Assert.assertEquals(veggies.size(),filtredList.size());







    }
}
