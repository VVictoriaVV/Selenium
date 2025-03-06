package com.rahulshettyacademy.tests;


import org.testng.annotations.Test;

public class PS1 extends PS {



    @Test
    public void testRun() {


        getSmth();//method belongs parent

        PS2 ps2=new PS2(3);
        int a =3;
        System.out.println( ps2.increment());
    }



    @Test
    public void test2() {


        getSmth();//method belongs parent

        PS3 ps3=new PS3(25);
        int a =25;
        System.out.println( ps3.miltiplyTwo());
        System.out.println(ps3.divideTwo());
    }
}
