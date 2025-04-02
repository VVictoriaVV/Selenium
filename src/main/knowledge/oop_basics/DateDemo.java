package oop_basics;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateDemo {
    public static void main(String[] args) {


        //current date and time
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(sdf.format(d));


        System.out.println(d.toString());
    }
}
