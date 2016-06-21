package com.egs.home.lesson1_2;

import java.util.Scanner;

public class Solution8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;
        while (number>=1){
            if (number%2==1){
                count++;
            }
            number/=2;
        }
        System.out.println(count);
    }
}
