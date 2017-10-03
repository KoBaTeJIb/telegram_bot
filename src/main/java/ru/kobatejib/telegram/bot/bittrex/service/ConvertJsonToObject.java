package ru.kobatejib.telegram.bot.bittrex.service;

/**
 * Created by Kovatelj 
 */
import com.google.gson.*;

import ru.kobatejib.telegram.bot.bittrex.dto.Summaries;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

public class ConvertJsonToObject {
	public Summaries summariesToObject(String response) {
		Gson gson = new Gson();
		Summaries summaries = gson.fromJson(response, Summaries.class);
		return summaries;
	}

	public Ticker ticketToObject(String response) {
		Gson gson = new Gson();
		Ticker ticker = gson.fromJson(response, Ticker.class);
		return ticker;
	}
}
