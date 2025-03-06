package com.rahulshettyacademy.pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);

        //switch window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> w = windows.iterator();
        String parentWindow = w.next();
        String childWindow = w.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");

        WebElement course = driver.findElement(By.xpath("//h2/a[@href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']"));
        String courseName = course.getText();
        driver.switchTo().window(parentWindow);
        WebElement inputName = driver.findElement(By.xpath("//input[@name='name']"));
        inputName.sendKeys(courseName);


        //screenshot
        File file = inputName.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));


        //Get hight &weight
        int sizeHeight = inputName.getRect().getDimension().getHeight();
        int sizeWidth = inputName.getRect().getDimension().getWidth();
        System.out.println(sizeWidth);
        System.out.println(sizeHeight);

    }
}
