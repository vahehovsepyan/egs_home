package com.egs.home.lesson5_6;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class Comparing {
    public static void main(String[] args) {

        LinkedList<String > strings = new LinkedList<>();
        strings.add("a1");
        strings.add("b15");
        strings.add("5");
        strings.add("2");
        strings.add("a240");
        strings.add("a25");

        System.out.println("список до сортирования: "+strings);

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };


        Comparator<String > intComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a=0,b=0;
                String []s1;
                String []s2;
                try {
                    a = Integer.parseInt(o1);
                    b = Integer.parseInt(o2);
                }catch (Exception e){
                    check(o1,o2);
                    //intComparator.compare()
                    stringComparator.compare(o1,o2);
                }
                return a-b;
            }
            public int check(String o1, String  o2) {
                String[] s1=o1.split("");
                String[]s2 = o2.split("");
                int dif=0;
                int length = 0;
                int a = 0;
                int b = 0;
                if (s1.length > s2.length) {
                    length = s2.length;
                } else length = s1.length;
                for (int i = 0; i < length; i++) {
                    try {
                        a = Integer.parseInt(s1[i]);
                        b = Integer.parseInt(s2[i]);
                    } catch (Exception e) {
                        continue;
                    }
                    if (a>b){
                        dif= o1.compareTo(o2);
                    }
                }
                return dif;
            }
        };


        Collections.sort(strings,stringComparator);
        System.out.println("список сортирован как стринг: "+strings);

        Collections.sort(strings,intComparator);
        System.out.println("список сортирован как цифры и буквы: "+strings);

    }

}
