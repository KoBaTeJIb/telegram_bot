package ru.kobatejib.telegram.bot.bittrex.service;

import ru.kobatejib.telegram.bot.bittrex.entyte.Order;
import ru.kobatejib.telegram.bot.bittrex.utility.DataBaseUtility;

import java.util.List;
import java.util.Map;
import java.util.TimerTask;

public class CheckOrdersService extends TimerTask{

    DataBaseService database = DataBaseService.getInstance();
    Bittrex wrapper = Bittrex.getINSTANCE();
    StringBuffer message_send = new StringBuffer();

    @Override
    public void run() {
        System.out.println("Timer Start");
        completeTask();
    }

    private void completeTask() {
        try {
            wrapper.setAuthKeysFromTextFile("/keys.properties");
            String responseOrder = wrapper.getOpenOrders();
            List<Map<String, String>> allOrderMapList = Bittrex.getMapsFromResponse(responseOrder);

            if (allOrderMapList.get(0) != null) {
                for (Map<String, String> orderMap : allOrderMapList) {
                    Order order = DataBaseUtility.map2Order(orderMap);
                    message_send.append(order.getExchange()).append("\t")
                            .append(order.getQuantity()).append("\n");
                    System.out.println(message_send.toString());
                }
            }
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
