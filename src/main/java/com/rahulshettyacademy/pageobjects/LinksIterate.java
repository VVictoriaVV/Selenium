package com.rahulshettyacademy.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LinksIterate {
    public static void main(String[] args) throws IOException {



        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));




        for (WebElement link : links) {

            String url = link.getDomAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int response = connection.getResponseCode();

            if (response > 400) {
                System.out.println(link.getText()+response);
            }
        }

    }
}


