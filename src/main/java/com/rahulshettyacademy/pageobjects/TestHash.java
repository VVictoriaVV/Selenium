package com.rahulshettyacademy.pageobjects;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestHash {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
