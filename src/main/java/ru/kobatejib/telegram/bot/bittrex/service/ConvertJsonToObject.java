package ru.kobatejib.telegram.bot.bittrex.service;

/**
 * Created by Kovatelj 
 */
import com.google.gson.*;

import com.google.gson.reflect.TypeToken;
import org.omg.CORBA.Object;
import ru.kobatejib.telegram.bot.bittrex.dto.Summaries;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

import java.util.HashMap;
import java.util.List;

public class ConvertJsonToObject {

	public static ConvertJsonToObject getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(ConvertJsonToObject INSTANCE) {
		ConvertJsonToObject.INSTANCE = INSTANCE;
	}

	public static ConvertJsonToObject INSTANCE = new ConvertJsonToObject();



	public Ticker ticketToObject(String response) {
		Gson gson = new Gson();
		Ticker ticker = gson.fromJson(response, Ticker.class);
		return ticker;
	}

	public List<Summaries> summariesToObject(String response) {
		Gson gson = new Gson();
		HashMap<String, Summaries> summariesMap = new HashMap<>();
		List<Summaries> summaries = gson.fromJson(response, new TypeToken<List<Summaries>>(){}.getType());
		for (int i = 0; i < summaries.size(); i++) {
			summariesMap.put(summaries.get(i).getMarketName(), summaries.get(i));
		}
		return summaries;
	}


}
