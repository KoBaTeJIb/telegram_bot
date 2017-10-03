package ru.kobatejib.telegram.bot.bittrex.service;

import com.google.gson.*;

import javassist.bytecode.stackmap.BasicBlock.Catch;
import ru.kobatejib.telegram.bot.bittrex.dto.Summaries;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

public class ConvertJsonToObject {
    public void summariesToObject (String response) {
        Gson gson = new Gson();
        Summaries summaries = gson.fromJson(response, Summaries.class);
 
    }
    
    public void ticketToObject(String response) {
		Gson gson = new Gson();
		Ticker ticker = gson.fromJson(response, Ticker.class);
    }
}
