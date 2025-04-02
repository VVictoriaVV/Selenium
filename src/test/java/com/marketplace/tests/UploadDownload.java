package com.marketplace.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UploadDownload {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        WebElement downLoadButton = driver.findElement(By.xpath("//button[@id='downloadButton']"));
        downLoadButton.click();

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='fileinput']"));
        chooseFile.sendKeys("/Users/79255/Downloads/download.xlsx");

        By toastLocator = By.xpath("//div[@class='Toastify__toast - body']/div");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
       String text = driver.findElement(toastLocator).getText();
        System.out.println(text);
        Assert.assertEquals("Updated Excel Data Successfully.", text);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));





    }
}