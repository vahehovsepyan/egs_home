package com.egs_home.lesson1_2;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String simvol = sc.nextLine();
        text=text.replace(simvol,"");
        System.out.println(text);
    }
}
