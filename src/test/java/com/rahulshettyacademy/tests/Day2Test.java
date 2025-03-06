package com.rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Day2Test extends BaseTest {
    @Test
    public void webLogin() {

    }

    @Test(dataProvider = "getData")
    public void mobileLogin(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];//3 combinations and 2 values
        //1 set
        data[0][0] = "firstUsername";
        data[0][1] = "password";
        //2set
        data[1][0] = "secondusername";
        data[1][1] = "secondpassword";
        //3set
        data[2][0] = "thirdusername";
        data[2][1] = "thirdpassword";

        return data;
    }


    @DataProvider
    public Object[][] getData1() throws IOException {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("email", "vik.fkdfk@gmail.com");
//        map.put("password", "123444");
//        map.put("product", "jeans");
//
        List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\data\\PurchaseOrder.json");
        {
            return new Object[][]{{data.get(0)}, {data.get(1)}};
        }

    }
}