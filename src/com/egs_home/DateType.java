package com.egs_home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateType {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String s = "31-08-1992 10:20:56";
        Date date1 = simpleDateFormat.parse(s);
        System.out.println(date1);


        Calendar cal= Calendar.getInstance();
        date1 = cal.getTime();
        System.out.println(date1);

        Calendar calendar = new GregorianCalendar(1981,0,31);
        simpleDateFormat.format(calendar.getTime());
        System.out.println(date1);


    }
}
