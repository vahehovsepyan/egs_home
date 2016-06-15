package com.egs_home.lesson4;

import java.util.*;

public class BooksProperties {
    HashMap<String ,Book > bookNames = new HashMap<>();
    HashMap<String ,Book[] > autorNames = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BooksProperties booksProperties = new BooksProperties();
        booksProperties.setBooksAndAutors();

        booksProperties.search();

    }
    public void search(){
        System.out.println("Введите текст для поиска: ");
        String text = sc.nextLine();
        if (bookNames.get(text)!=null){
            System.out.println("Имя книги: "+bookNames.get(text).name+"" +
                    ", имя автора: "+bookNames.get(text).autor+"" +
                    ", год выпуска: "+ bookNames.get(text).age);
        }else if(autorNames.get(text)!=null){
            for (int i = 0; i < autorNames.get(text).length; i++) {
                System.out.println("Имя автора: "+text+"" +
                        ", имя книги: "+autorNames.get(text)[i].name+"" +
                        " год выпуска: "+ bookNames.get(autorNames.get(text)[i].name).age);
            }
        }else {
            System.out.println("не найдено такая книга");
        }
    }

    public void setBooksAndAutors(){
        bookNames.put("java7",new Book("java7","Shildt",2011));
        bookNames.put("java8",new Book("java8","Shildt",2014));
        bookNames.put("ThinkingJava",new Book("ThinkingJava","Ekkel",2011));
        autorNames.put("Shildt",new Book[]{new Book("java7"),new Book("java8")});
        autorNames.put("Ekkel",new Book[]{new Book("ThinkingJava")});
    }
    class Book{
        String name;
        String autor;
        int age;

        public Book(String name){
            this.name= name;
        }

        public Book(String name,String autor,int age){
            this.name = name;
            this.autor=autor;
            this.age=age;
        }
    }
}