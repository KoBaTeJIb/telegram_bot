package ru.kobatejib.telegram.bot.bittrex.service;

import ru.kobatejib.telegram.bot.bittrex.entyte.Order;
import ru.kobatejib.telegram.bot.bittrex.utility.DataBaseUtility;

import java.sql.SQLException;
import java.util.*;

public class CheckOrdersService extends TimerTask {

    DataBaseService database = DataBaseService.getInstance();
    Bittrex wrapper = Bittrex.getINSTANCE();


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
            List<Order> ordersOld = new ArrayList<>();
            List<Order> ordersNew = new ArrayList<>();
            List<Order> ordersDB = new ArrayList<>();
            ordersDB = database.findAllByClosed(null);


            if (allOrderMapList.get(0) != null) {
                StringBuffer message_send = new StringBuffer();

                if (allOrderMapList.get(0) != null) {
                    for (Map<String, String> orderMap : allOrderMapList) {
                        Order order = DataBaseUtility.map2Order(orderMap);
                        boolean itsNew = true;

                        for (Order orderDb : ordersDB) {
                            if (order.getOrderUuid().equals(orderDb.getOrderUuid())) {
                                ordersOld.add(order);
                                itsNew = false;
                            }
                        }

                        if (itsNew) {
                            ordersNew.add(order);
                        }
                        /*message_send.append(order.getExchange()).append("\t")
                                .append(order.getQuantity()).append("\n");*/
                    }
                    //System.out.println(message_send.toString());
                }
                if(!ordersNew.isEmpty()) {
                    for (Order order : ordersNew) {
                        database.writeDb(order);
                        System.out.println("Ордер " + order.getExchange() + "\t" + order.getQuantity()
                                            + "\t - Закрыт\n");
                    }
                }
            }


            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
