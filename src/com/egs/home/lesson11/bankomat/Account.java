package com.egs.home.lesson11.bankomat;

public class Account {
    private volatile int money=2000;
    private  boolean isStop=false;
    int x;
    public boolean isStop() {
        return isStop;
    }

    public  int getMoney() {
        return money;
    }

    public  void showMony(){
        System.out.println(" проверка денег "+money);
    }

    public synchronized  void withdrawMoney(String name){

        x = (int) (Math.random()*20+1);
        x*=10;
        if (x<money){
            money-=x;
            System.out.println(name+" снял со счета "+x);
        }else {
            isStop=true;
            System.out.println("недостаточно средств на счету!");
        }
    }

}
