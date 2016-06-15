package com.egs_home.lesson3;

public class EvenOdd {
    public static void main(String[] args) {
       double [] vec = {12.4, 5.45, 5, 4, 6, 7.3, 9};
        int number;
        for (int i = 0; i < vec.length; i++) {
            number=(int)vec[i]/1;
            if (vec[i]-number==0){
                if (vec[i]%2==0){
                    System.out.println(vec[i]);
                }
            }

        }
    }
}
