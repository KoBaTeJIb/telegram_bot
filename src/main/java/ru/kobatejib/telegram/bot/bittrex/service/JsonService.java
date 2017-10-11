package ru.kobatejib.telegram.bot.bittrex.service;

/**
 * Created by Kovatelj 
 */
import com.google.gson.*;

import com.google.gson.reflect.TypeToken;
import ru.kobatejib.telegram.bot.bittrex.dto.Summaries;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

public class JsonService {

	public static JsonService getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(JsonService INSTANCE) {
		JsonService.INSTANCE = INSTANCE;
	}

	public static JsonService INSTANCE = new JsonService();



	public Ticker ticketToObject(String response) {
		Gson gson = new Gson();
		Ticker ticker = gson.fromJson(response, Ticker.class);
		return ticker;
	}

	public List<Summaries> summariesToObject(String response) {
		System.out.println(response);
		Gson gson = new Gson();
		HashMap<String, Summaries> summariesMap = new HashMap<>();
		//List<Summaries> summaries = gson.fromJson(response, new TypeToken<List<Summaries>>(){}.getType());
		Summaries summaries = gson.fromJson(response, Summaries.class);
		for (int i = 0; i < summaries.getResult().length; i++) {
			summariesMap.put(summaries.getResult()[i]., summaries.getResult()[i]);
		}
		return summaries;
	}


}
