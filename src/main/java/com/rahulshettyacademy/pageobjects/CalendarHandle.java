package com.rahulshettyacademy.pageobjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarHandle {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement calendar = driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']"));
        //  WebElement calendar = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']"));
        calendar.click();
        WebElement buttonYear = driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']"));
        buttonYear.click();
        buttonYear.click();

        String year = "2028";
        String day = "15";
        String month = "6";
        String[] schedule={month,day,year};

        WebElement currentYear = driver.findElement(By.xpath("//button[text()='" + year + "']"));
        currentYear.click();

        WebElement currentMonth = driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(month));
        currentMonth.click();

        WebElement currentDay = driver.findElement(By.xpath("//abbr[text()='" + day + "']"));
        currentDay.click();


        WebElement dateField = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']"));
        dateField.getText();


        List<WebElement> actualList = driver.findElements(By.xpath("//input[@class='react-date-picker__inputGroup__input ']"));
        for (int i = 0; i < actualList.size(); i++)
        {
          actualList.get(i);
         //   Assert.assertEquals(actualList.get(i),schedule);
        }
    }
}
