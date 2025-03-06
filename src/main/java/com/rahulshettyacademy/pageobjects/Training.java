package com.rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class Training {
    public static void main(String[] args) throws InterruptedException {

        WebDriverWait wait;

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // field Country
        WebElement country = driver.findElement(By.xpath("//*[@id='autosuggest']"));
        country.sendKeys("ac");
        Thread.sleep(2000);

        List<WebElement> listOfCountries = driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
        for (WebElement listOfCountry : listOfCountries) {
            if (listOfCountry.getText().equalsIgnoreCase("Macedonia, The Former Yugoslav Republic of")) {
                listOfCountry.click();
                break;
            }
        }
        //CheckBox
        WebElement checkBoxes = driver.findElement(By.xpath("//*[@id='StudentDiv']"));
        checkBoxes.click();
        //   Assert.assertFalse(checkBoxes.isSelected());
        // System.out.println(checkBoxes.isSelected());

        // Count the number of checkboxes
        System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());


        // 1. Currency field
        //Select method for dropdown currency
        WebElement currencyDropDown = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown = new Select(currencyDropDown);

        //get for index
        dropdown.selectByIndex(3);
        dropdown.getFirstSelectedOption().getText();

        //get for text
        dropdown.selectByVisibleText("AED");
        dropdown.getFirstSelectedOption().getText();

        //get for value
        dropdown.selectByValue("INR");
        dropdown.getFirstSelectedOption().getText();


        //2.Passenger field
        // Select method for dropdown Passengers
        WebElement passengerDropDown = driver.findElement(By.xpath("//*[@id='divpaxinfo']"));
        passengerDropDown.click();

        Thread.sleep(1000L);


        // need to choose 5 times, so have to use for loop
        for (int i = 1; i < 5; i++) {
            WebElement adultVariable = driver.findElement(By.xpath("//*[@id='hrefIncAdt']"));
            adultVariable.click();
            System.out.println(passengerDropDown.getText());
        }

        //press button "Done"
        WebElement buttonDone = driver.findElement(By.xpath("//*[@id='btnclosepaxoption']"));
        buttonDone.click();


        //3. Destination from - to
        // "FROM"
        WebElement fromBox = driver.findElement(By.xpath("//div[@class='left1']"));
        fromBox.click();
        WebElement fromField = driver.findElement(By.xpath("//*[@id ='ctl00_mainContent_ddl_originStation1']"));
        WebElement choiceDestinationFrom = driver.findElement(By.xpath("//a[@value='GOI']"));
        choiceDestinationFrom.click();
        Thread.sleep(2000);

        //"TO"
        WebElement toBox = driver.findElement(By.xpath("//div[@class='right1']"));
        WebElement choiceDestinationTo = driver.findElement(By.xpath("(//a[@value='SXR'])[2]")); //"//a[@value='SXR']"));//
        choiceDestinationTo.click();


        // Calendar
        WebElement date = driver.findElement(By.xpath("//td[@data-month='5' and a[text()='20']]"));
        date.click();


       //Search
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
        searchButton.click();


        //close driver
        driver.quit();
    }
}
