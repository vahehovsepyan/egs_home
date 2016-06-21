package com.egs.home.lesson11.bankomat;

public class Client extends Thread{

    Account account = new Account();


    @Override
    public void run() {
        System.out.println(currentThread().getName()+" стартует");

        while (!account.isStop()){

            account.showMony();
            System.out.println(currentThread().getName()+"хочет снять ");
            account.withdrawMoney(currentThread().getName());
        }
    }
}
