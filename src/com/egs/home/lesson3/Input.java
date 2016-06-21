package com.egs.home.lesson3;

import java.util.Scanner;


// пользователь вводит символы , пока не будет введена "q"
public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String q="";
        while (!q.equals("q")){
            q=sc.nextLine();
            System.out.println(q);
        }
    }
}
