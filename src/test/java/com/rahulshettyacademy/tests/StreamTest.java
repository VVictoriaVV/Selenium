package com.rahulshettyacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("ABHDYWDGEGE");
        names.add("jelmls");
        names.add("Ahthea");
        names.add("loiiugkE");
        names.add("mvieowmh");

        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }

        }
        System.out.println(count);

    }

    @Test
    public void StreamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("ABHDYWDGEGE");
        names.add("jelmls");
        names.add("Ahthea");
        names.add("loiiugkE");
        names.add("mvieowmh");

        Long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);


        Long d = Stream.of("DKJWID", "Bjwhwuh", "Lnygfuy", "Ltdryft").filter(s ->
        {
            s.startsWith("L");
            return true;
        }).count();
        System.out.println(d);

        // names.stream().filter(s -> s.length()>7).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() > 7).limit(4).forEach(s -> System.out.println(s));
    }


    @Test
    public void streamMap() {


        Stream.of("DKJWID", "Bjwhwuh", "Lnygfuy", "Ltdryft", "Ders").filter(s -> s.endsWith("y")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        List<String> names1 = Arrays.asList("DKJWID", "Bjwhwuh", "Lnygfuy", "Ltdryft");
        names1.stream().filter(s -> s.startsWith("L")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


        //
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ders");
        names.add("jkujy");
        names.add("jhggdrtesg");
        names.add("wgtjyy");
        names.add("bfhdhdt");

        Stream<String> streamOf2 = Stream.concat(names.stream(), names1.stream());
        boolean flag = streamOf2.anyMatch((s -> s.equalsIgnoreCase("Ders")));

        System.out.println(flag);
        Assert.assertTrue(flag);


    }

    @Test
    public void streamCollect() {
        List<String> streamLs = Stream.of("DKJWID", "Bjwhwuh", "Lnygfuy", "Ltdryft", "Ders").filter(s -> s.endsWith("y")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(streamLs.get(0));

        //print unique number from array = distinct()-get only unique values
        List<Integer> numbers = Arrays.asList(6, 7, 7, 2, 4, 9, 5, 6, 1, 3, 4, 6, 5, 9, 9, 0);

    //    numbers.stream().distinct().forEach(s -> System.out.println(s));
       List<Integer> list= numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list);


    }

    @Test
    public void streamSorted()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on coloumn
        WebElement nameOfFood = driver.findElement(By.xpath("//tr/th[@aria-label='Veg/fruit name: activate to sort column ascending']"));
        nameOfFood.click();


        //capture all webelemnts into list
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//tr/td[1]"));

//        capture text of all webelemnts into new(original) list
//        for (int i = 0; i < listOfProducts.size(); i++) {
//            System.out.println(listOfProducts.get(i).getText());
        //List<String> elementOfProducts = listOfProducts.get(i).getText();
//        }
        List<String> originalList = listOfProducts.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort on the original list->sorted list

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare original list and sorted list
       Assert.assertTrue(originalList.equals(sortedList));
    }
    }







