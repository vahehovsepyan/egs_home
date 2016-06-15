package com.egs_home.lesson5_6;

import java.util.Scanner;

public class Months  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 0-11: ");
        int month = sc.nextInt();
        Month[] arr = Month.values();
        System.out.println(arr[month]);
    }
    enum Month{
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNY,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;
    }

}


