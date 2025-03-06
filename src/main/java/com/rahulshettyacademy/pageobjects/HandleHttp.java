package com.rahulshettyacademy.pageobjects;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class HandleHttp {
    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);
        options.setAcceptInsecureCerts(true);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://expered.badssl.com/");



    }
}
