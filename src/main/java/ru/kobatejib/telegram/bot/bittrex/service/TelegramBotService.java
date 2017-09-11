package ru.kobatejib.telegram.bot.bittrex.service;
/**
 * Created by Sazonovs on 06.07.2017.
 */


import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import ru.kobatejib.telegram.bot.bittrex.entyte.Order;
import ru.kobatejib.telegram.bot.bittrex.utility.DataBaseUtility;


import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

public class TelegramBotService extends TelegramLongPollingBot {

	// public telegramBot() throws SQLException {
	// }

	/*
	 * public class checkOrdersOpen extends TimerTask {
	 * 
	 * @Override public void run() { Bittrex wrapper = new Bittrex();
	 * wrapper.setAuthKeysFromTextFile("keys.txt");
	 * 
	 * String responseOrders = wrapper.getOpenOrders(); List<HashMap<String,
	 * String>> allOrderList = Bittrex.getMapsFromResponse(responseOrders); } }
	 */

	DataBaseService database = new DataBaseService();

	@Override
	public void onUpdateReceived(Update update) {
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			Bittrex wrapper = new Bittrex();
			wrapper.setAuthKeysFromTextFile("/keys.properties");
			StringBuffer message_send = new StringBuffer();
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();

			switch (message_text) {
			case "balances":
				String otherRawResponse = wrapper.getBalances();
				List<Map<String, String>> allBalancesMapList = Bittrex.getMapsFromResponse(otherRawResponse);
				for (int i = 0; i < allBalancesMapList.size(); i++) {
					if (!allBalancesMapList.get(i).get("Balance").equals("0.00000000")) {
						message_send.append(allBalancesMapList.get(i).get("Currency")).append("\t")
								.append(allBalancesMapList.get(i).get("Balance")).append("\n");
					}
				}
				SendMessage messageBalances = new SendMessage().setChatId(chat_id).setText(message_send.toString());

				try {
					sendMessage(messageBalances); // Sending our message object
													// to user
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
				break;

			case "orders":
				String responseOrder = wrapper.getOpenOrders();
				List<Map<String, String>> allOrderMapList = Bittrex.getMapsFromResponse(responseOrder);
				if (allOrderMapList.get(0) == null) {
					SendMessage messageOrders = new SendMessage().setChatId(chat_id).setText("Нет открытых ордеров");
					try {
						sendMessage(messageOrders); // Sending our message
													// object to user
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} else {
					for (Map<String, String> orderMap: allOrderMapList) {
						Order order = DataBaseUtility.map2Order(orderMap);
						try {
							database.writeDb(order);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}

						message_send.append(order.getExchange()).append("\n")
								.append(order.getQuantity()).append("\n");
					}
					SendMessage messageOrders = new SendMessage().setChatId(chat_id).setText(message_send.toString());
					try {
						sendMessage(messageOrders); // Sending our message
													// object to user
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
				break;

			case "/help":
				SendMessage messageHelp = new SendMessage().setChatId(chat_id).setText("Custom message text");
				// message.setChatId(chat_id);
				// message.setText("Custom message text");

				// Create ReplyKeyboardMarkup object
				ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
				// Create the keyboard (list of keyboard rows)
				keyboardMarkup.setResizeKeyboard(true);
				List<KeyboardRow> keyboard = new ArrayList<>();
				// Create a keyboard row
				KeyboardRow row = new KeyboardRow();

				// Set each button, you can also use KeyboardButton objects if
				// you need something else than text
				row.add("balances");
				row.add("orders");
				row.add("db");
				keyboard.add(row);
				keyboardMarkup.setKeyboard(keyboard);
				// Add it to the message
				messageHelp.setReplyMarkup(keyboardMarkup);

				try {
					// Send the message
					sendMessage(messageHelp);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
				break;
				
			case "db":
				List<Order> orders = new ArrayList<Order>();
				try {
					orders = database.findAllByClosed(null);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(!orders.isEmpty()) {
					for(Order order: orders) {
						String exchange = order.getExchange();
						System.out.println(exchange);
						SendMessage messageOrders = new SendMessage().setChatId(chat_id).setText(exchange);
						try {
							sendMessage(messageOrders); // Sending our message object to
														// user
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
				

				break;

			}
		}
	}

	@Override
	public String getBotUsername() {
		return "KoBaTeJIb_bot";
	}

	@Override
	public String getBotToken() {
		return "357230969:AAHZbPksnG6ubGC5hVcQz_-vIHsoYnAf49g";
	}
}

// https://monsterdeveloper.gitbooks.io/writing-telegram-bots-on-java/content/chapter1.html