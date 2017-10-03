package ru.kobatejib.telegram.bot.bittrex.service;

import ru.kobatejib.telegram.bot.bittrex.entyte.Order;
import ru.kobatejib.telegram.bot.bittrex.utility.DataBaseUtility;

import java.sql.SQLException;
import java.util.*;

public class CheckOrdersService extends TimerTask {

    DataBaseService database = DataBaseService.getInstance();
    Bittrex wrapper = Bittrex.getINSTANCE();
    TelegramBotService telegramBotService = TelegramBotService.getINSTANCE();

    StringBuffer sendMessage = new StringBuffer();


    @Override
    public void run() {
        System.out.println("Timer Start");
        sendMessage.append("Timer Start");
        String message = sendMessage.toString();
        telegramBotService.SendMessage(message);
        completeTask();
    }

    private void completeTask() {
        try {
            wrapper.setAuthKeysFromTextFile("/keys.properties");
            String responseOrder = wrapper.getOpenOrders();
            List<Map<String, String>> allOrderMapList = Bittrex.getMapsFromResponse(responseOrder);
            List<Order> ordersOld = new ArrayList<>();
            List<Order> ordersNew = new ArrayList<>();
            List<Order> ordersDB = database.findAllByClosed(null);
            List<Order> ordersDelete = new ArrayList<>();

            if (allOrderMapList.get(0) != null) {
                List<Order> ordersBittrex = new ArrayList<>();
                for (Map<String, String> orderMap : allOrderMapList) {
                    Order order = DataBaseUtility.map2Order(orderMap);
                    ordersBittrex.add(order);
                }

                for (Order orderBittrex : ordersBittrex) {
                    boolean isNew = true;
                    for (Order orderDB : ordersDB) {
                        if (orderBittrex.getOrderUuid().equals(orderDB.getOrderUuid())) {
                            ordersOld.add(orderBittrex);
                            isNew = false;
                        }
                    }
                    if (isNew) {
                        ordersNew.add(orderBittrex);
                    }
                }

                for (Order orderDB : ordersDB) {
                    boolean isDelete = true;
                    for (Order orderOld : ordersOld) {
                        if (orderDB.getOrderUuid().equals(orderOld.getOrderUuid())) {
                            isDelete = false;
                        }
                    }
                    if (isDelete) {
                        ordersDelete.add(orderDB);
                    }
                }

                if (!ordersNew.isEmpty()) {
                    for (Order order : ordersNew) {
                        database.writeDb(order);
                        sendMessage.append("Ордер ").append(order.getExchange()).append("\t")
                                .append(order.getQuantity()).append("\t - добавлен в БД\n");
                        System.out.println("Ордер " + order.getExchange() + "\t" + order.getQuantity()
                                + "\t - добавлен в БД\n");
                        telegramBotService.SendMessage(sendMessage.toString());

                    }
                }

                if (!ordersDelete.isEmpty()) {
                    for (Order order : ordersDelete) {
                        database.updateDb(order.getOrderUuid(), "closed");
                        sendMessage.append("Ордер ").append(order.getExchange()).append("\t")
                                .append(order.getQuantity()).append("\t - закрыт\n");
                        System.out.println("Ордер " + order.getExchange() + "\t" + order.getQuantity()
                                + "\t - Закрыт\n");
                        telegramBotService.SendMessage(sendMessage.toString());
                    }
                }
            }

                Thread.sleep(0);
            } catch(InterruptedException e){
                e.printStackTrace();
            } catch(SQLException e){
                e.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            }

        }



}
