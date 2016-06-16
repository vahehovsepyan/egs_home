package com.egs_home.lesson11.bankomat;

public class Account {
    private static int money=2000;
    private boolean isStop=false;

    public boolean isStop() {
        return isStop;
    }

    public int getMoney() {
        return money;
    }



    public synchronized void withdrawMoney(String name, int x){
        if (x<getMoney()){
            money-=x;
            System.out.println(name+" снял со счета "+x);
            System.out.println(name+"! Сумма на счету: "+getMoney());
        }else {
            isStop=true;
            System.out.println("недостаточно средств на счету!");
        }
    }

}
