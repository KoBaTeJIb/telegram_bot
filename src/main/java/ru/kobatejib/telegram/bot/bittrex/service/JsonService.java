package ru.kobatejib.telegram.bot.bittrex.service;

/**
 * Created by Kovatelj 
 */
import com.google.gson.*;



import ru.kobatejib.telegram.bot.bittrex.dto.Response;
import ru.kobatejib.telegram.bot.bittrex.dto.Summaries;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

import java.util.Arrays;
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

	public HashMap<String, Summaries> summariesToObject(String response) {
		System.out.println(response);
		Gson gson = new Gson();
		HashMap<String, Summaries> summariesMap = new HashMap<>();
		Response responseSummaries = gson.fromJson(response, Response.class);
		
		List<Summaries> summaries = responseSummaries.getSummaries();
		System.out.println(Arrays.toString(summaries.toArray()));
		if(summaries != null) {
			for (Summaries summary: summaries) {
				summariesMap.put(summary.getMarketName(), summary);
			}
		}
		return summariesMap;
	}


}
