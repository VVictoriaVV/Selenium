package com.rahulshettyacademy.pageobjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on coloumn
        WebElement nameOfFood = driver.findElement(By.xpath("//tr/th[@aria-label='Veg/fruit name: activate to sort column ascending']"));
        nameOfFood.click();


        //capture all webelemnts into list
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//tr/td[1]"));

//        capture text of all webelemnts into new(original) list
//        for (int i = 0; i < listOfProducts.size(); i++) {
//            System.out.println(listOfProducts.get(i).getText());
        //List<String> elementOfProducts = listOfProducts.get(i).getText();
//        }
        List<String> originalList = listOfProducts.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort on the original list->sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        List<String> price;
        do {
            List<WebElement> coloumnOfProducts = driver.findElements(By.xpath("//tr/td[1]"));
            price = coloumnOfProducts.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPrice(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.xpath("//li/a[@aria-label='Next']")).click();
            }
        } while (price.size() < 1);

    }

    private static String getPrice(WebElement s) {

        String value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return value;
    }
}
