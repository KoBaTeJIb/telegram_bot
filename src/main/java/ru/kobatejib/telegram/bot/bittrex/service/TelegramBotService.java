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


import ru.kobatejib.telegram.bot.bittrex.dto.Summaries;
import ru.kobatejib.telegram.bot.bittrex.entyte.Order;
import ru.kobatejib.telegram.bot.bittrex.utility.DataBaseUtility;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

public class TelegramBotService extends TelegramLongPollingBot {

	private static TelegramBotService INSTANCE = new TelegramBotService();

	public static TelegramBotService getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(TelegramBotService INSTANCE) {
		TelegramBotService.INSTANCE = INSTANCE;
	}

	final long CHAT_ID = 231358447;


	DataBaseService database = DataBaseService.getInstance();
	JsonService jsonService = JsonService.getINSTANCE();

	@Override
	public void onUpdateReceived(Update update) {
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			Bittrex wrapper = Bittrex.getINSTANCE();
			wrapper.setAuthKeysFromTextFile("/keys.properties");
			StringBuffer message_send = new StringBuffer();
			String message_text = update.getMessage().getText();
			/*if(CHAT_ID == 0) {
				CHAT_ID = update.getMessage().getChatId();
				System.out.println(CHAT_ID);
			}*/

			switch (message_text) {
			case "balances":
				String otherRawResponse = wrapper.getBalances();
				String summariesResponse = wrapper.getMarketSummaries();
				List<Map<String, String>> allBalancesMapList = Bittrex.getMapsFromResponse(otherRawResponse);
				for (int i = 0; i < allBalancesMapList.size(); i++) {
					if (!allBalancesMapList.get(i).get("Balance").equals("0.00000000")) {
						message_send.append(allBalancesMapList.get(i).get("Currency")).append("\t")
								.append(allBalancesMapList.get(i).get("Balance")).append("\t");
								//.append(allBalancesMapList.get(i).get(""))

					}
				}
				List<Summaries> summaries = jsonService.summariesToObject(summariesResponse);

				for (int i = 0; i < summaries.size(); i++) {
					System.out.println(summaries.get(i).getDisplayMarketName());
				}
				SendMessage messageBalances = new SendMessage().setChatId(CHAT_ID).setText(message_send.toString());

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
					SendMessage messageOrders = new SendMessage().setChatId(CHAT_ID).setText("Нет открытых ордеров");
					try {
						sendMessage(messageOrders); // Sending our message
													// object to user
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} else {
					for (Map<String, String> orderMap: allOrderMapList) {
						Order order = DataBaseUtility.map2Order(orderMap);
						message_send.append(order.getExchange()).append("\t")
								.append(order.getOrderType())
								.append(order.getQuantity()).append("\n");
					}
					SendMessage messageOrders = new SendMessage().setChatId(CHAT_ID).setText(message_send.toString());
					try {
						sendMessage(messageOrders); // Sending our message
													// object to user
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
				break;

			case "/help":
				SendMessage messageHelp = new SendMessage().setChatId(CHAT_ID).setText("Бот для работы с биржей Bittrex");
				// message.setChatId(CHAT_ID);
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
				//row.add("db");
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

			}
		}
	}


	public void SendMessage (String message) {
		SendMessage text = new SendMessage().setChatId(CHAT_ID).setText(message);
		try {
			sendMessage(text);
		} catch (TelegramApiException e) {
			e.printStackTrace();
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

	public void setDatabase(DataBaseService database) {
		this.database = database;
	}

	
}

// https://monsterdeveloper.gitbooks.io/writing-telegram-bots-on-java/content/chapter1.html