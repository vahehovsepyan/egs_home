package com.egs_home.lesson3;

import java.util.Scanner;

public class SwichTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату и сезон:");
        System.out.println("Пример ввода: 13/12/16 Зима");
        String[] text = sc.nextLine().split(" ");

        //получаем дату и сезон
        String date = text[0];
        String season = text[1];
        season=season.toLowerCase();

       /* //определяем номер месяца
        String m = date.split("/")[1];
        int month = Integer.parseInt(m);
       */
        switch (season){
            case "зима":
                System.out.println("одется очень тепло");
                break;
            case "весна":
                System.out.println("одеться тепло");
                break;
            case "лето":
                System.out.println("одеться очень легко");
                break;
            case "осень":
                System.out.println("одеться легко");
                break;
            default:
                System.out.println("введено некорректно ");

        }

    }
}
