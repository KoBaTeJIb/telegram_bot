package ru.kobatejib.telegram.bot.bittrex;

/**
 Стартовый класс для telegram bot
 @author Kovatelj
* Created by Kovatelj on 06.07.2017.
 */

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import ru.kobatejib.telegram.bot.bittrex.service.CheckOrdersService;
import ru.kobatejib.telegram.bot.bittrex.service.DataBaseService;
import ru.kobatejib.telegram.bot.bittrex.service.TelegramBotService;

import java.sql.SQLException;
import java.util.*;

public class Starter {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException  {

		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();
		DataBaseService db = DataBaseService.getInstance();
		try {
			TelegramBotService tb =  new TelegramBotService();
			tb.setDatabase(db);
			botsApi.registerBot(tb);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}

		db.connect();
		db.createDb();


		TimerTask timerTask = new CheckOrdersService();
		// стартуем TimerTask в виде демона

		Timer timer = new Timer(true);
		// будем запускать каждых 10 секунд (10 * 1000 миллисекунд)
		timer.scheduleAtFixedRate(timerTask, 0, 60*1000);
		System.out.println("TimerTask начал выполнение");
	}

		
}
