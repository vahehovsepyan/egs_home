package com.egs.home.lesson1_2;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        StringBuilder sb = new StringBuilder(text1);

        String text2 = sb.reverse().toString();
        if (text1.equals(text2)){
            System.out.println("строка является палиндромом.");
        }else {
            System.out.println("строка НЕ является палиндромом.");
        }
    }
}
