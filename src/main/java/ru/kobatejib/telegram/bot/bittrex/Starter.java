package ru.kobatejib.telegram.bot.bittrex;

/**
 Стартовый класс для telegram bot
 @author Kovatelj
* Created by Kovatelj on 06.07.2017.
 */

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import ru.kobatejib.telegram.bot.bittrex.service.Bittrex;
import ru.kobatejib.telegram.bot.bittrex.service.CheckOrders;
import ru.kobatejib.telegram.bot.bittrex.service.DataBaseService;
import ru.kobatejib.telegram.bot.bittrex.service.TelegramBotService;

import java.sql.SQLException;
import java.util.*;

public class Starter {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException  {

		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();
		DataBaseService db = new DataBaseService();
		try {
			TelegramBotService tb =  new TelegramBotService();
			tb.setDatabase(db);
			botsApi.registerBot(tb);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}

		db.connect();
		db.createDb();


		// Timer timer = new Timer();
		// timer.schedule(new checkOrdersOpen(), 1000, 5000);

		Bittrex wrapper = new Bittrex();
		wrapper.setAuthKeysFromTextFile("/keys.properties");
		// String rawResponse = wrapper.getMarketSummary("BTC-LTC");
		// List<HashMap<String, String>> responseMapList =
		// Bittrex.getMapsFromResponse(rawResponse);

		// In some cases, only 1 map is actually returned - if this is assured:
		// HashMap<String, String> onlyMap = responseMapList.get(0);

		// See available information using present keys
		// for (String key : onlyMap.keySet())

		// System.out.print(key + " ");

		// System.out.println();

		// Get wanted value using a key found in the KeySet
		// onlyMap.get("Volume");

		// Some responses have more than 1 map - the List must be traversed in
		// these cases.
		String otherRawResponse = wrapper.getBalances();
		List<Map<String, String>> allBalancesMapList = Bittrex.getMapsFromResponse(otherRawResponse);

		// for (HashMap<String, String> map : allBalancesMapList)

		// System.out.println(map);

		// And then the wanted map can be used

		// System.out.println(allBalancesMapList.get(3).get("Balance") + " " +
		// allBalancesMapList.get(3).get("Currency"));
		// for (int i = 0; i < allBalancesMapList.size(); i++) {
		// System.out.println(allBalancesMapList.get(i).get("Currency") + " " +
		// allBalancesMapList.get(i).get("Balance"));
		// }

		String responseOrder = wrapper.getOpenOrders();
		List<Map<String, String>> allOrderMapList = Bittrex.getMapsFromResponse(responseOrder);

		// for (HashMap<String, String> map : allOrderMapList)
		// System.out.println(map);

		// System.out.println(allOrderMapList.get(0).get("Exchange") + " " +
		// allOrderMapList.get(0).get("Quantity"));
		// System.out.println(responseOrder);
		
		TimerTask timerTask = new CheckOrders();
		// стартуем TimerTask в виде демона

		Timer timer = new Timer(true);
		// будем запускать каждых 10 секунд (10 * 1000 миллисекунд)
		timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
		System.out.println("TimerTask начал выполнение");
	}

		
}
