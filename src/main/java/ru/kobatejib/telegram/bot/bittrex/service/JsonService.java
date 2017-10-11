package ru.kobatejib.telegram.bot.bittrex.service;

/**
 * Created by Kovatelj 
 */
import com.google.gson.*;



import ru.kobatejib.telegram.bot.bittrex.dto.Response;
import ru.kobatejib.telegram.bot.bittrex.dto.Summary;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

import java.util.HashMap;


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

	public HashMap<String, Summary> summariesToObject(String response) {
		System.out.println(response);
		Gson gson = new Gson();
		HashMap<String, Summary> summariesMap = new HashMap<>();
		//List<Summaries> summaries = gson.fromJson(response, new TypeToken<List<Summaries>>(){}.getType());
		Response responseSummaries = gson.fromJson(response, Response.class);
		Summary[] summaries = responseSummaries.getSummaries();
		if(summaries != null) {
			for (int i = 0; i < summaries.length; i++) {
				summariesMap.put(summaries[i].getMarketName(), summaries[i]);
			}
		} 
		
		return summariesMap;
	}


}
