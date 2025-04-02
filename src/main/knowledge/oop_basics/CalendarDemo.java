package oop_basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));
        System.out.println( calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println( calendar.get(Calendar.MONTH) + 1);
        System.out.println( calendar.get(Calendar.YEAR));
        System.out.println( calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.AM_PM));


    }
}
