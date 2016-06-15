package com.egs_home.lesson4;

import java.util.Properties;

public class TestProperties {

    static Properties prop = new Properties();

    public static void main(String args[]) {

        prop.put("Title","put title here");

        prop.put("Author","put name here");

        prop.put("isbn", "isbn not set");

        Properties book = new Properties(prop);

        book.put("Title","The Java Handbook");

        book.put("Author","Patrick Naughton");

        book.put("isbn","2002");



        System.out.println("Title: " +

                book.getProperty("Title"));
        System.out.println("Author: " +

                book.getProperty("Author"));

        System.out.println("isbn: " +

                book.getProperty("isbn"));

        System.out.println("ean: " +

                book.getProperty("ean","???"));

    }
}

