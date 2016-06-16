package com.egs_home.lesson11.bankomat;

public class Client extends Thread{

    Account account = new Account();
    int x;

    @Override
    public void run() {
        while (!account.isStop()){
            x = (int) (Math.random()*20+1);
            x*=10;

           // account.showMoney(currentThread().getName());
            System.out.println();
            account.withdrawMoney(currentThread().getName(),x);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
