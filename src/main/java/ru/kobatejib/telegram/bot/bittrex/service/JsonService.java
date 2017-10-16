package ru.kobatejib.telegram.bot.bittrex.service;

/**
 * Created by Kovatelj 
 */
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import ru.kobatejib.telegram.bot.bittrex.dto.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<String, Summary> summariesToObject(String response) {
		System.out.println("response: " + response);

		Map<String, Summary> summariesMap = new HashMap<>();
		Type listType = new TypeToken<Response<List<Summary>>>(){}.getType();
		Gson gson = new Gson();
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

	public Object summaryToObject (String response) {
		Gson gson = new Gson();
		Type type = new TypeToken<Response<Summary>>(){}.getType();
		Response<Summary> responseSummary = gson.fromJson(response, type);
		return responseSummary;
	}

	public Object tickerToObject (String response) {
		Gson gson = new Gson();
		Type type = new TypeToken<Response<Ticker>>(){}.getType();
		Response<Summary> responseTicker = gson.fromJson(response, type);
		return responseTicker;
	}

	public Map<String, Currencies> currenciesToObject (String response) {
		Map<String, Currencies> currenciesMap = new HashMap<>();
		Gson gson = new Gson();
		Type listType = new TypeToken<Response<List<Currencies>>>(){}.getType();
		Response<List<Currencies>> responseCurrencies = gson.fromJson(response, listType);
		List<Currencies> currencies = responseCurrencies.getResult();

		if(currencies != null) {
			for (Currencies currency : currencies) {
				currenciesMap.put(currency.getCurrency(), currency);
			}
		}
		return currenciesMap;
	}

	public Map<String, Markets> marketsToObject (String response) {
		Map<String, Markets> marketsMap = new HashMap<>();
		Gson gson = new Gson();
		Type listType = new TypeToken<Response<List<Markets>>>(){}.getType();
		Response<List<Markets>> responseMarkets = gson.fromJson(response, listType);
		List<Markets> markets = responseMarkets.getResult();

		if(markets != null) {
			for (Markets market : markets) {
				marketsMap.put(market.getMarketCurrency(), market);
			}
		}
		return marketsMap;
	}

	public Map<Integer, MarketHistory> marketHistoryToObject (String response) {
		Map<Integer, MarketHistory> historyMap = new HashMap<>();
		Gson gson = new Gson();
		Type listType = new TypeToken<Response<List<MarketHistory>>>(){}.getType();
		Response<List<MarketHistory>> responseHistory = gson.fromJson(response, listType);
		List<MarketHistory> markets = responseHistory.getResult();

		if(markets != null) {
			for (MarketHistory market : markets) {
				historyMap.put(market.getId(), market);
			}
		}
		return historyMap;
	}



}
