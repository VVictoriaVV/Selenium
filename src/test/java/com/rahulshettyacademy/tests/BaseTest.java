package com.rahulshettyacademy.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class BaseTest {
    public WebDriver driver = null;

    Logger logger = null;

    WebDriverWait wait = null;


    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string
        String json = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        System.out.println(json);


        //String to HashMap Jackson Datbind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {

        });
        System.out.println(data);
        return data;
    }

    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png");
        FileUtils.copyFile(source,file);

        return System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png";
    }
}


