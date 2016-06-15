package com.egs_home.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookLibrary {
    HashMap<String, String> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.addBooks();

        System.out.println("Введите текст для поиска: ");
        String text = bookLibrary.sc.nextLine();
        bookLibrary.search(text);
    }

    public void search(String text){
        if (!text.isEmpty()){
            for (Map.Entry<String, String> pair :
                    map.entrySet()) {
                if (map.get(text)!=null || pair.getValue().contains(text)){
                    System.out.println("Книга: "+pair.getKey()+
                            " Автор: " +pair.getValue());
                }
            }
        }
    }

    public void addBooks(){
        String book;
        String autor;
        while (true){
            System.out.println("Введите имя книги: ");
            book=sc.nextLine();
            if (book.isEmpty()){
                System.out.println("Добавление остановлено!");
                break;
            }
            System.out.println("Введите имя автора и год выпуска книги через пробел: ");
            autor = sc.nextLine();
            String [] checkYear = autor.split(" ");
            try {
                Integer.parseInt(checkYear[1]);
            }catch (Exception e){
                System.out.println("введите корректрное число !!! ");
                continue;
            }

            map.put(book,autor);
        }
    }

    public void searchByAutor(String autor){
        for (Map.Entry<String, String> pair :
                map.entrySet()) {
            if (pair.getValue().contains(autor)){
                System.out.println("Книга: "+pair.getKey()+
                        "Автор " +pair.getValue());
            }
        }
    }

    public void searchByBook(String book){
        for (Map.Entry<String, String> pair :
         map.entrySet()) {
            if (pair.getKey().equals(book)){
                System.out.println("Книга: "+pair.getKey()+
                                   "Автор " +pair.getValue());
            }
        }
    }
}
