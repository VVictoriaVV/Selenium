package com.rahulshettyacademy.pageobjects;


public class Chinchilla {

    public static void main(String[] args) {
        getCountOfLetter("chinchilla", 'a');
    }

    public static int getCountOfLetter(String word, char letter) {
        int count = 0;
        char[] chars = word.toCharArray();
        for (int y = 0; y < chars.length; y++) {
            if (chars[y] == letter) {
                count++;
            }

        }
        System.out.println(count);
        return count;
    }


}

