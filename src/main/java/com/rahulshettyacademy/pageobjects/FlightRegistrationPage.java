package com.rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.rahulshettyacademy.pageobjects.BasePage;

public class FlightRegistrationPage extends BasePage {


    public FlightRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void getPage() {
        super.getDriver("/dropdownsPractise");
    }


    public void select(){
        WebElement staticDropDown = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown = new Select(staticDropDown);
        dropdown.selectByIndex(3);
        dropdown.getFirstSelectedOption().getText();
    }
}
