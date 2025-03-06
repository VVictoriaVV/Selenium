package com.rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerLinks = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        System.out.println(footerLinks.findElements(By.tagName("a")).size());

        WebElement leftCol = driver.findElement(By.xpath("//td[1]/ul"));
        //  System.out.println(leftCol.findElements(By.tagName("a")).size());

        Integer size = leftCol.findElements(By.tagName("a")).size();
        for (int i = 1; i < size; i++) {
            String clickOnLinkOnNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            leftCol.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkOnNewTab);


            //open all tabs
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> w = windows.iterator();
            String previous = null;
            while (w.hasNext()) {
                driver.switchTo().window(w.next());
                if (previous == null) {
                    previous = driver.getWindowHandle();
                }

            }
            driver.switchTo().window(previous);
        }

        driver.quit();
    }
}
