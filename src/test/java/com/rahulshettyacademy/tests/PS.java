package com.rahulshettyacademy.tests;

import org.testng.annotations.BeforeMethod;

public class PS {
   public void getSmth(){
       System.out.println("I extend your method ");
   }
    @BeforeMethod
    public void beforeRun(){
        System.out.println("Run me first");
    }

}
