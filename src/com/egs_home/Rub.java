package com.egs_home;

public class Rub {
    public static void main(String[] args) {
        Rub r = new Rub();
        r.go();

    }

    public void go(){
        int x = 1000;
        String number = "";
        for (int i = 1; i < 1000; i++) {
            number+=i;
        }
        String[] s = number.split("");

        System.out.println(number);
        System.out.println(s[2007]);

    }
}
