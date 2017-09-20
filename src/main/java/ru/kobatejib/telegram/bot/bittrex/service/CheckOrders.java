package ru.kobatejib.telegram.bot.bittrex.service;

import java.util.TimerTask;

public class CheckOrders extends TimerTask{


    @Override
    public void run() {
        System.out.println("Timer Start");
        completeTask();
    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 20 секунд
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
