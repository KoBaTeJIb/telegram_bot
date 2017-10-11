package ru.kobatejib.telegram.bot.bittrex.service;

/**
 * Created by Kovatelj 
 */
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import ru.kobatejib.telegram.bot.bittrex.dto.Response;
import ru.kobatejib.telegram.bot.bittrex.dto.Summary;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

import java.lang.reflect.Type;
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

	public HashMap<String, Summary> summariesToObject(String response) {
		System.out.println(response);
		Gson gson = new Gson();
		HashMap<String, Summary> summariesMap = new HashMap<>();
		Type listType = new TypeToken<Response<List<Summary>>>() {
		}.getType();
		Response<List<Summary>> responseSummaries = gson.fromJson(response, listType);

		List<Summary> summaries = responseSummaries.getResult();

		System.out.println(Arrays.toString(summaries.toArray()));
		if (summaries != null) {
			for (Summary summary : summaries) {
				summariesMap.put(summary.getMarketName(), summary);
			}
		}
		return summariesMap;
	}

}
