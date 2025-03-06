package com.rahulshettyacademy.pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class Frames {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");




        //switch to frame on web site
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));



        //move element(d&d)
        Actions a = new Actions(driver);
        WebElement dragFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropTo = driver.findElement(By.xpath("//div[@id='droppable']"));
        a.dragAndDrop(dragFrom,dropTo).build().perform();


        //screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(("C:\\Users\\79255\\OneDrive\\Рабочий стол\\screenJava\\screenshot.png")));

        driver.switchTo().defaultContent();

        driver.quit();
    }
}
