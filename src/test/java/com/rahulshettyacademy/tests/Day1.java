package com.rahulshettyacademy.tests;

import org.testng.annotations.*;

public class Day1 {
    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }


    @Test(dependsOnMethods = {"sth"})
    public void something() {
        System.out.println("mfkrrgrm");
    }


    @BeforeSuite
    public void fmkfwII() {
        System.out.println("before suite");
    }

    @BeforeMethod
    public void lkwmfwfrw() {
        System.out.println("before metod");
    }

    @AfterMethod
    public void lkterhgu() {
        System.out.println("after metod");
    }

    @AfterSuite
    public void nkelw() {
        System.out.println("after suite");
    }

    @Test(groups = {"Smoke"})
    public void sth() {
        System.out.println("4442232");
    }

    @BeforeTest
    public void ejrioewj() {
        System.out.println("Push before test");
    }

    @AfterTest
    public void someDriver() {
        System.out.println("After testa ");
    }

    @Test(enabled = false)
    public void soddwfw() {
        System.out.println("enabled ");

    }
    @Parameters({"url"})
    @Test(timeOut = 300)
    public void dwfw() {
        System.out.println("timeout ");
        System.out.println("url inside method");

    }
    @Parameters({"url"})
    @Test
    public void dw(String urlName) {
        System.out.println("parametr ");
        System.out.println(urlName);

    }

    @Parameters({"url"})
    @Test
    public void eeeeeew(String url) {
        System.out.println("parametr in method @eeeeeew");


    }
}




